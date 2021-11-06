package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class DentistaDaoImpl implements IDao<Dentista> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoImpl.class);

    public DentistaDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }


    @Override
    public Dentista salvar(Dentista dentista) {
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
            log.debug("Registrando o dentista: " + dentista.getNome() + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dentista;
    }

    @Override
    public Dentista alterar(Dentista dentista) {
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = String.format("UPDATE dentista set numeromatricula = '%s', nome = '%s', sobrenome = '%s' where id = '%s'",
                dentista.getNumeroMatricula(), dentista.getNome(), dentista.getSobrenome(), dentista.getId());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            dentista = buscar(dentista.getId()).get();
            statement.close();
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        log.debug("Dados atualizados: " + dentista);
        return dentista;
    }

    @Override
    public void excluir(Integer id) {
        log.debug("Excluir dentista cadastrado com id: " + id + ".");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        Dentista dentista = buscar(id).get();
        String query = "DELETE FROM dentista WHERE id = " + id;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Dentista> buscar(Integer id) {
        log.debug("Busca dentista cadastrados com id: " + id + ".");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;
        String query = "SELECT * FROM dentista WHERE id = " + id;
        Dentista dentista = null;
        try {
            statement = connection.createStatement();
            ResultSet busca = statement.executeQuery(query);
            while (busca.next())
                dentista = criarNovoDentista(busca);
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dentista != null ? Optional.of(dentista): Optional.empty();
    }

    @Override
    public List<Dentista> listarTodos() {
        log.debug("Listando todos os dentista cadastrados.");
        Connection connection = configuracaoJDBC.conectarBanco();
        Statement statement = null;

        String query = "SELECT * FROM dentista";
        List<Dentista> dentistas = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet buscar = statement.executeQuery(query);
            while (buscar.next()) {
                dentistas.add(criarNovoDentista(buscar));
            }
            statement.close();
            connection.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return dentistas;
    }

    private Dentista criarNovoDentista(ResultSet buscar) throws SQLException {
        Integer id = buscar.getInt("id");
        Integer numeroMatricula = buscar.getInt("numeromatricula");
        String nome = buscar.getString("nome");
        String sobrenome = buscar.getString("sobrenome");
        return new Dentista(id, numeroMatricula, nome, sobrenome);
    }

}
