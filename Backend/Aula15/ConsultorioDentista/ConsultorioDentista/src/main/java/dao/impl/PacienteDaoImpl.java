package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteDaoImpl implements IDao<Paciente> {
    private ConfiguracaoJDBC configuracaoJDBC;
    private EnderecoDaoImpl enderecoDao;

    public PacienteDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDao = new EnderecoDaoImpl();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        paciente.setEndereco(enderecoDao.salvar(paciente.getEndereco()));
        String query = String.format("INSERT INTO pacientes(nome,sobrenome,rg,dataDeCadastro,enderecoId) VALUES('%s','%s','%s','%s','%s')",
                paciente.getNome(), paciente.getSobrenome(), paciente.getRg(), Util.dateToTimestamp(paciente.getDataDeCadastro()), paciente.getEndereco().getId());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                paciente.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("SELECT * FROM pacientes where id = '%s'", id);
        Paciente paciente = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                paciente = criarObjetoPaciente(result);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("SELECT * FROM pacientes");
        List<Paciente> pacientes = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                pacientes.add(criarObjetoPaciente(result));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        Paciente paciente = buscar(id).get();
        String query = String.format("DELETE FROM pacientes where id = %s", id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            enderecoDao.excluir(paciente.getEndereco().getId());
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paciente alterar(Paciente paciente) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("UPDATE pacientes set nome = '%s',sobrenome = '%s',rg = '%s',dataDeCadastro = '%s'  where id = '%s'",
                paciente.getNome(), paciente.getSobrenome(), paciente.getRg(), Util.dateToTimestamp(paciente.getDataDeCadastro()), paciente.getId());
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                paciente = criarObjetoPaciente(result);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    private Paciente criarObjetoPaciente(ResultSet result) throws SQLException {
        Integer idPaciente = result.getInt("id");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String rg = result.getString("rg");
        Date dataDeCadastro = result.getDate("dataDeCadastro");
        Endereco endereco = enderecoDao.buscar(result.getInt("enderecoId")).orElse(null);
        return new Paciente(idPaciente, nome, sobrenome, rg, dataDeCadastro, endereco);
    }
}
