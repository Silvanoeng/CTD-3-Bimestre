package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConfiguracaoJDBC {
    private String jdbcDrive;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    private static final String SQL_CREATE_TABLE_DEN = "CREATE TABLE IF NOT EXISTS dentista" +
            "(" +
            "id int auto_increment primary key, " +
            "numeromatricula int," +
            "nome varchar(40), " +
            "sobrenome varchar(100))";

    public ConfiguracaoJDBC(String jdbcDrive, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDrive = jdbcDrive;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public ConfiguracaoJDBC() {
        this.jdbcDrive = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test";
        this.nomeUsuario = "sa";
        this.senha = "";

        criarTabela();
    }

    private void criarTabela(){
        try {
            Connection connection = conectarBanco();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE_DEN);
            connection.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection conectarBanco() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
