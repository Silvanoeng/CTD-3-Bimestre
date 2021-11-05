package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ConfiguracaoJDBC {
    private String jdbcDrive;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;


    private static final String SQL_CREATE_TABLE_END = "DROP TABLE IF EXISTS endereco CASCADE; CREATE TABLE endereco " +
            "(" +
            "idEnd int auto_increment primary key, " +
            "rua varchar(150), " +
            "numero varchar(15), " +
            "cidade varchar(50), " +
            "estado varchar(50))";

    private static final String SQL_CREATE_TABLE_PAC = "DROP TABLE IF EXISTS paciente; CREATE TABLE paciente " +
            "(" +
            "idPac int auto_increment primary key, " +
            "nome varchar(40), " +
            "sobrenome varchar(100), " +
            "RG varchar(25), " +
            "dataDeCadastro varchar(25), " +
            "idEnd int, " +
            "FOREIGN KEY (idEnd) REFERENCES endereco (idEnd))";



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
            statement.execute(SQL_CREATE_TABLE_END);
            statement.execute(SQL_CREATE_TABLE_PAC);
            connection.close();

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
