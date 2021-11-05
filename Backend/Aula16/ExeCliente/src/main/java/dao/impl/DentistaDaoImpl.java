package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DentistaDaoImpl implements IDao<Dentista> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoImpl.class);

    public DentistaDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        log.debug("Registrando um novo dentista.");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = String.format("INSERT INTO dentista(numeromatricula, nome, sobrenome) VALUES('%s','%s','%s')",
                dentista.getNumeroMatricula(), dentista.getNome(), dentista.getSobrenome());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                dentista.setIdDen(keys.getInt(1));

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dentista;
    }

    @Override
    public List<Dentista> listarTodos() {
        log.debug("Registrando um novo dentista.");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = "SELECT * FROM dentista";
        List<Dentista> dentistas = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet busca = statement.executeQuery(query);
            while (busca.next()) {
                Integer idDen = busca.getInt("idDen");
                Integer numeroMatricula = busca.getInt("numeromatricula");
                String nome = busca.getString("nome");
                String sobrenome = busca.getString("sobrenome");
                dentistas.add(new Dentista(idDen, numeroMatricula, nome, sobrenome));
            }
            statement.close();
            connection.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return dentistas;
    }

}
