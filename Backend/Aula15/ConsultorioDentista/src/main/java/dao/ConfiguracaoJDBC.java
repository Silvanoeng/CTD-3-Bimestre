package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class  ConfiguracaoJDBC {
    private String jdbcDriver;
    private String url;
    private String usuario;
    private String senha;

    private static final String SQL_CREATE_TABLE_PAC = "CREATE TABLE IF NOT EXISTS pacientes" +
            "(" +
            "id int auto_increment primary key," +
            "nome varchar(40)," +
            "sobrenome varchar(100)," +
            "rg varchar(20)," +
            "dataDeCadastro TIMESTAMP WITHOUT TIME ZONE," +
            "idEnd int);";

    private static final String SQL_CREATE_TABLE_END = "CREATE TABLE IF NOT EXISTS enderecos" +
            "(" +
            "id int auto_increment primary key," +
            "rua varchar(100)," +
            "numero varchar(20)," +
            "cidade varchar(50)," +
            "estado varchar (50));";

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
            statement.execute(SQL_CREATE_TABLE_PAC);
            statement.execute(SQL_CREATE_TABLE_END);
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
