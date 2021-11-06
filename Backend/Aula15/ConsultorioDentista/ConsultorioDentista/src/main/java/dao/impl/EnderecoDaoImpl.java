package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Endereco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoImpl implements IDao<Endereco> {
    private ConfiguracaoJDBC configuracaoJDBC;

    public EnderecoDaoImpl() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("INSERT INTO enderecos(rua,numero,cidade,estado) VALUES('%s','%s','%s','%s')",
                endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado());
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                endereco.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public Optional<Endereco> buscar(Integer id) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("SELECT * FROM enderecos where id = '%s'", id);
        Endereco endereco = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                endereco = criarObjetoEndereco(result);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }

    @Override
    public List<Endereco> buscarTodos() {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("SELECT * FROM enderecos");
        List<Endereco> enderecos = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                enderecos.add(criarObjetoEndereco(result));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("DELETE FROM enderecos where id = %s", id);
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
    public Endereco alterar(Endereco endereco) {
        Connection connection = configuracaoJDBC.conectarBase();
        Statement statement = null;
        String query = String.format("UPDATE enderecos set rua = '%s' ,numero = '%s',cidade = '%s',estado = '%s' where id = '%s'",
                endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getEstado(), endereco.getId());
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next())
                endereco = criarObjetoEndereco(result);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endereco;
    }

    private Endereco criarObjetoEndereco(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        String rua = result.getString("rua");
        String numero = result.getString("numero");
        String cidade = result.getString("cidade");
        String estado = result.getString("estado");

        return new Endereco(id, rua, numero, cidade, estado);
    }
}
