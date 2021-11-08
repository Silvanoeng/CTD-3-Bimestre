package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;
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
    final static Logger log = Logger.getLogger(PacienteDaoImpl.class);

    public PacienteDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDao = new EnderecoDaoImpl();
    }

    @Override
    public Paciente salvar(Paciente pacienteSalvar) {
        Connection connectionSalvar = configuracaoJDBC.conectarBase();
        Statement statementSalvar = null;
        pacienteSalvar.setEndereco(enderecoDao.salvar(pacienteSalvar.getEndereco()));
        String querySalvar = String.format("INSERT INTO pacientes(nome, sobrenome, rg, dataDeCadastro, idEnd) VALUES('%s','%s','%s','%s','%s')",
                pacienteSalvar.getNome(), pacienteSalvar.getSobrenome(), pacienteSalvar.getRg(), Util.dateToTimestamp(pacienteSalvar.getDataDeCadastro()), pacienteSalvar.getEndereco().getIdEnd());
        try {
            statementSalvar = connectionSalvar.createStatement();
            statementSalvar.executeUpdate(querySalvar, Statement.RETURN_GENERATED_KEYS);
            ResultSet keysSalvar = statementSalvar.getGeneratedKeys();
            if(keysSalvar.next())
                pacienteSalvar.setIdPac(keysSalvar.getInt(1));
            statementSalvar.close();
            connectionSalvar.close();
            log.debug("Registrando o paciente: " + pacienteSalvar.getNome() + ".");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pacienteSalvar;
    }

    @Override
    public Paciente alterar(Paciente pacienteAlterar) {
        Connection connectionAlterar = configuracaoJDBC.conectarBase();
        Statement statementAlterar = null;

        String queryAlterar = String.format("UPDATE pacientes SET nome = '%s', sobrenome = '%s', rg = '%s', dataDeCadastro = '%s'  WHERE id = '%s'",
                pacienteAlterar.getNome(), pacienteAlterar.getSobrenome(), pacienteAlterar.getRg(), Util.dateToTimestamp(pacienteAlterar.getDataDeCadastro()), pacienteAlterar.getIdPac());
        try {
            statementAlterar = connectionAlterar.createStatement();
            statementAlterar.executeUpdate(queryAlterar);
            pacienteAlterar = buscar(pacienteAlterar.getIdPac()).get();
            statementAlterar.close();
            connectionAlterar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Dados atualizados: " + pacienteAlterar);
        return pacienteAlterar;
    }

    @Override
    public void excluir(Integer idExcluir) {
        log.debug("Excluir paciente cadastrado com id: " + idExcluir + ".");
        Connection connectionExcluir = configuracaoJDBC.conectarBase();
        Statement statementExcluir = null;

        Paciente pacienteExcluir = buscar(idExcluir).get();
        String queryExcluir = "DELETE FROM pacientes where id =" + idExcluir;
        try {
            statementExcluir = connectionExcluir.createStatement();
            statementExcluir.executeUpdate(queryExcluir);
            enderecoDao.excluir(pacienteExcluir.getEndereco().getIdEnd());
            statementExcluir.close();
            connectionExcluir.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<Paciente> buscar(Integer idBuscar) {
        log.debug("Busca paciente cadastrado com id: " + idBuscar + ".");
        Connection connectionBuscar = configuracaoJDBC.conectarBase();
        Statement statementBuscar = null;

        String queryBuscar = "SELECT * FROM pacientes where id =" + idBuscar;
        Paciente pacienteBuscar = null;
        try {
            statementBuscar = connectionBuscar.createStatement();
            ResultSet resultBuscar = statementBuscar.executeQuery(queryBuscar);
            while (resultBuscar.next())
                pacienteBuscar = criarObjetoPaciente(resultBuscar);
            statementBuscar.close();
            connectionBuscar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pacienteBuscar != null ? Optional.of(pacienteBuscar) : Optional.empty();
    }

    @Override
    public List<Paciente> buscarTodos() {
        log.debug("Listando todos os pacientes cadastrados.");
        Connection connectionTodos = configuracaoJDBC.conectarBase();
        Statement statementTodos = null;

        String queryTodos = "SELECT * FROM pacientes";
        List<Paciente> pacientesTodos = new ArrayList<>();
        try {
            statementTodos = connectionTodos.createStatement();
            ResultSet resultTodos = statementTodos.executeQuery(queryTodos);
            while (resultTodos.next())
                pacientesTodos.add(criarObjetoPaciente(resultTodos));
            statementTodos.close();
            connectionTodos.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pacientesTodos;
    }

    private Paciente criarObjetoPaciente(ResultSet result) throws SQLException {
        Integer idPac = result.getInt("id");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String rg = result.getString("rg");
        Date dataDeCadastro = result.getDate("dataDeCadastro");
        Endereco endereco = enderecoDao.buscar(result.getInt("idEnd")).orElse(null);
        return new Paciente(idPac, nome, sobrenome, rg, dataDeCadastro, endereco);
    }
}
