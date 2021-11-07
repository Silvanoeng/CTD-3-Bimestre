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
import java.util.Optional;

public class DentistaDaoImpl implements IDao<Dentista> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(DentistaDaoImpl.class);

    public DentistaDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    @Override
    public Dentista salvar(Dentista dentistaSalvar) {
        Connection connectionSalvar = configuracaoJDBC.conectarBanco();
        Statement statementSalvar = null;

        String querySalvar = String.format("INSERT INTO dentista(numeromatricula, nome, sobrenome) VALUES('%s','%s','%s')",
                dentistaSalvar.getNumeroMatricula(), dentistaSalvar.getNome(), dentistaSalvar.getSobrenome());
        try {
            statementSalvar = connectionSalvar.createStatement();
            statementSalvar.executeUpdate(querySalvar, Statement.RETURN_GENERATED_KEYS);
            ResultSet keysSalvar = statementSalvar.getGeneratedKeys();
            if (keysSalvar.next())
                dentistaSalvar.setIdDen(keysSalvar.getInt(1));
            statementSalvar.close();
            connectionSalvar.close();
            log.debug("Registrando o dentista: " + dentistaSalvar.getNome() + ".");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dentistaSalvar;
    }

    @Override
    public Dentista alterar(Dentista dentistaAlterar) {
        Connection connectionAlterar = configuracaoJDBC.conectarBanco();
        Statement statementAlterar = null;

        String queryAlterar = String.format("UPDATE dentista SET numeromatricula = '%s', nome = '%s', sobrenome = '%s' WHERE id = '%s'",
                dentistaAlterar.getNumeroMatricula(), dentistaAlterar.getNome(), dentistaAlterar.getSobrenome(), dentistaAlterar.getIdDen());
        try {
            statementAlterar = connectionAlterar.createStatement();
            statementAlterar.executeUpdate(queryAlterar);
            dentistaAlterar = buscar(dentistaAlterar.getIdDen()).get();
            statementAlterar.close();
            connectionAlterar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Dados atualizados: " + dentistaAlterar);
        return dentistaAlterar;
    }

    @Override
    public void excluir(Integer idExcluir) {
        log.debug("Excluir dentista cadastrado com id: " + idExcluir + ".");
        Connection connectionExcluir = configuracaoJDBC.conectarBanco();
        Statement statementExcluir = null;

        String queryExcluir = "DELETE FROM dentista WHERE id = " + idExcluir;
        try {
            statementExcluir = connectionExcluir.createStatement();
            statementExcluir.executeUpdate(queryExcluir);
            statementExcluir.close();
            connectionExcluir.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Optional<Dentista> buscar(Integer idBuscar) {
        log.debug("Busca dentista cadastrado com id: " + idBuscar + ".");
        Connection connectionBuscar = configuracaoJDBC.conectarBanco();
        Statement statementBuscar = null;

        String queryBuscar = "SELECT * FROM dentista WHERE id = " + idBuscar;
        Dentista dentistaBuscar = null;
        try {
            statementBuscar = connectionBuscar.createStatement();
            ResultSet resultBuscar = statementBuscar.executeQuery(queryBuscar);
            while (resultBuscar.next())
                dentistaBuscar = criarNovoDentista(resultBuscar);
            statementBuscar.close();
            connectionBuscar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dentistaBuscar != null ? Optional.of(dentistaBuscar): Optional.empty();
    }

    @Override
    public List<Dentista> listarTodos() {
        log.debug("Listando todos os dentistas cadastrados.");
        Connection connectionTodos = configuracaoJDBC.conectarBanco();
        Statement statementTodos = null;

        String queryTodos = "SELECT * FROM dentista";
        List<Dentista> dentistasTodos = new ArrayList<>();
        try {
            statementTodos = connectionTodos.createStatement();
            ResultSet resultTodos = statementTodos.executeQuery(queryTodos);
            while (resultTodos.next())
                dentistasTodos.add(criarNovoDentista(resultTodos));
            statementTodos.close();
            connectionTodos.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return dentistasTodos;
    }

    private Dentista criarNovoDentista(ResultSet buscar) throws SQLException {
        Integer id = buscar.getInt("id");
        Integer numeroMatricula = buscar.getInt("numeromatricula");
        String nome = buscar.getString("nome");
        String sobrenome = buscar.getString("sobrenome");
        return new Dentista(id, numeroMatricula, nome, sobrenome);
    }

}
