package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    private String jdbcDriver;
    private String url;
    private String usuario;
    private String senha;

    private static final String SQL_CREATE_TABLE_PACIENTES = "create table IF NOT EXISTS pacientes" +
            "(" +
            "id int auto_increment primary key," +
            "nome varchar(255)," +
            "sobrenome varchar(255)," +
            "rg varchar(255)," +
            "dataDeCadastro TIMESTAMP WITHOUT TIME ZONE," +
            "enderecoId int);";

    private static final String SQL_CREATE_TABLE_ENDERECOS = "create table IF NOT EXISTS enderecos" +
            "(" +
            "id int auto_increment primary key," +
            "rua varchar(255)," +
            "numero varchar(255)," +
            "cidade varchar(255)," +
            "estado varchar (255));";

    public ConfiguracaoJDBC(String jdbcDriver, String url, String usuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.url = "jdbc:h2:~/test";
        this.usuario = "sa";
        this.senha = "";

        criarTabelas();
    }

    private void criarTabelas() {
        try {
            Connection connection = conectarBase();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE_PACIENTES);
            statement.execute(SQL_CREATE_TABLE_ENDERECOS);
            statement.close();
            connection.close();
        } catch (Exception e) {

        }
    }

    public Connection conectarBase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
