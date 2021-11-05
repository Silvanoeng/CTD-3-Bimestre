package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PacienteDaoImpl implements IDao<Paciente> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(PacienteDaoImpl.class);

    public PacienteDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        log.debug("Registrando um novo endereço: " + paciente.toString());
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query1 = String.format("INSERT INTO endereco(rua, numero, cidade, estado) VALUES('%s','%s','%s','%s')",
                paciente.getEndereco().getRua(), paciente.getEndereco().getNumero(), paciente.getEndereco().getCidade(), paciente.getEndereco().getEstado());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query1, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys1 = statement.getGeneratedKeys();
            if (keys1.next())
                paciente.getEndereco().setIdEnd(keys1.getInt(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
        String query2 = String.format("INSERT INTO paciente(nome,sobrenome, RG, dataDeCadastro, idEnd) VALUES('%s','%s','%s','%s','%s')",
                paciente.getNome(), paciente.getSobrenome(), paciente.getRG(), paciente.getDataDeCadastro(), paciente.getEndereco().getIdEnd());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query2, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys2 = statement.getGeneratedKeys();
            if (keys2.next())
                paciente.setIdPac(keys2.getInt(1));

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }




    @Override
    public Paciente buscar(Integer idPac) {
        log.debug("Buscando o paciente id: " + idPac);
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("SELECT pac.idPac, pac.nome, pac.sobrenome, pac.RG, pac.dataDeCadastro, pac.IdEnd," +
                        " end.rua, end.numero, end.cidade, end.estado FROM paciente pac" +
                        " INNER JOIN endereco end ON pac.idEnd=end.idEnd " +
                        "WHERE pac.'%s'", idPac);
        Paciente paciente = null;
        Endereco endereco = null;
        try {
            statement = connection.createStatement();
            ResultSet keys = statement.getGeneratedKeys();
            while (keys.next()) {
//                Integer idPac1 = keys.getInt("idPac");
                String nome = keys.getString("nome");
                String sobrenome = keys.getString("sobrenome");
                String RG = keys.getString("RG");
                String dataDeCadastro = keys.getString("dataDeCadastro");
                Integer idEnd = keys.getInt("idEnd");
                String rua = keys.getString("rua");
                String numero = keys.getString("numero");
                String cidade = keys.getString("cidade");
                String estado = keys.getString("estado");
                endereco = new Endereco(idEnd, rua, numero, cidade, estado);
                paciente = new Paciente(idPac, nome, sobrenome, RG, dataDeCadastro, endereco);
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }


    @Override
    public void deletar(Integer idPac) {
        log.debug("Deletando paciente id: " + idPac);
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("DELETE FROM paciente WHERE ID= '%s'", idPac);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paciente editar(Integer id) {

        return null;
    }

}
