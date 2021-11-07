package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoImpl implements IDao<Endereco> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(EnderecoDaoImpl.class);

    public EnderecoDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    @Override
    public Endereco salvar(Endereco enderecoSalvar) {
        Connection connectionSalvar = configuracaoJDBC.conectarBase();
        Statement statementSalvar = null;

        String querySalvar = String.format("INSERT INTO enderecos(rua, numero, cidade, estado) VALUES('%s','%s','%s','%s')",
                enderecoSalvar.getRua(), enderecoSalvar.getNumero(), enderecoSalvar.getCidade(), enderecoSalvar.getEstado());
        try {
            statementSalvar = connectionSalvar.createStatement();
            statementSalvar.executeUpdate(querySalvar, Statement.RETURN_GENERATED_KEYS);
            ResultSet keysSalvar = statementSalvar.getGeneratedKeys();
            if(keysSalvar.next())
                enderecoSalvar.setIdEnd(keysSalvar.getInt(1));
            statementSalvar.close();
            connectionSalvar.close();
            log.debug("Registrando o endereço: " + enderecoSalvar + ".");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return enderecoSalvar;
    }

    @Override
    public Endereco alterar(Endereco enderecoAlterar) {
        Connection connectionAlterar = configuracaoJDBC.conectarBase();
        Statement statementAlterar = null;

        String queryAlterar = String.format("UPDATE enderecos SET rua = '%s' , numero = '%s', cidade = '%s', estado = '%s' WHERE id = '%s'",
                enderecoAlterar.getRua(), enderecoAlterar.getNumero(), enderecoAlterar.getCidade(), enderecoAlterar.getEstado(), enderecoAlterar.getIdEnd());
        try {
            statementAlterar = connectionAlterar.createStatement();
            statementAlterar.executeUpdate(queryAlterar);
            enderecoAlterar = buscar(enderecoAlterar.getIdEnd()).get();
            statementAlterar.close();
            connectionAlterar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        log.debug("Dados atualizados: " + enderecoAlterar);
        return enderecoAlterar;
    }

    @Override
    public void excluir(Integer idExcluir) {
        log.debug("Excluir endereço cadastrado com id: " + idExcluir + ".");
        Connection connectionExcluir = configuracaoJDBC.conectarBase();
        Statement statementExcluir = null;

        String queryExcluir = "DELETE FROM enderecos where id =" + idExcluir;
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
    public Optional<Endereco> buscar(Integer idBuscar) {
        log.debug("Busca endereço cadastrado com id: " + idBuscar + ".");
        Connection connectionBuscar = configuracaoJDBC.conectarBase();
        Statement statementBuscar = null;

        String queryBuscar = "SELECT * FROM enderecos where id =" + idBuscar;
        Endereco enderecoBuscar = null;
        try {
            statementBuscar = connectionBuscar.createStatement();
            ResultSet resultBuscar = statementBuscar.executeQuery(queryBuscar);
            while (resultBuscar.next())
                enderecoBuscar = criarObjetoEndereco(resultBuscar);
            statementBuscar.close();
            connectionBuscar.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return enderecoBuscar != null ? Optional.of(enderecoBuscar) : Optional.empty();
    }

    @Override
    public List<Endereco> buscarTodos() {
        log.debug("Listando todos os endereços cadastrados.");
        Connection connectionTodos = configuracaoJDBC.conectarBase();
        Statement statementTodos = null;

        String queryTodos = "SELECT * FROM enderecos";
        List<Endereco> enderecosTodos = new ArrayList<>();
        try {
            statementTodos = connectionTodos.createStatement();
            ResultSet resultTodos = statementTodos.executeQuery(queryTodos);
            while (resultTodos.next())
                enderecosTodos.add(criarObjetoEndereco(resultTodos));
            statementTodos.close();
            connectionTodos.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return enderecosTodos;
    }

    private Endereco criarObjetoEndereco(ResultSet result) throws SQLException {
        Integer idEnd = result.getInt("id");
        String rua = result.getString("rua");
        String numero = result.getString("numero");
        String cidade = result.getString("cidade");
        String estado = result.getString("estado");
        return new Endereco(idEnd, rua, numero, cidade, estado);
    }
}
