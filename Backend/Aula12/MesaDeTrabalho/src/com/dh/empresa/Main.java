package com.dh.empresa;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    private static final String CREATE_TABLE = "DROP TABLE IF EXISTS EMPRESA;" +
            "CREATE TABLE EMPRESA(" +
            "ID INT PRIMARY KEY, " +
            "PRIMEIRO_NOME varchar(100), " +
            "SOBRENOME varchar(100), " +
            "IDADE INT, CIDADE varchar(100))";

    private static final String maria = "INSERT INTO EMPRESA (ID, PRIMEIRO_NOME, SOBRENOME, IDADE, CIDADE) " +
            "VALUES (1, 'Maria', 'Aparecida', 50, 'Porto Alegre')";
    private static final String joao = "INSERT INTO EMPRESA (ID, PRIMEIRO_NOME, SOBRENOME, IDADE, CIDADE)" +
            " VALUES (2, 'João', 'Carlos', 45, 'Curitiba')";
    private static final String pedro = "INSERT INTO EMPRESA (ID, PRIMEIRO_NOME, SOBRENOME, IDADE, CIDADE)" +
            " VALUES (2, 'Pedro', 'Araujo', 38, 'São Paulo')";

    private static final String update = "UPDATE EMPRESA SET SOBRENOME = 'Marcos' WHERE ID=2";
    private static final String delete = "DELETE FROM EMPRESA WHERE ID=1";
    private static final String delete2 = "DELETE FROM EMPRESA WHERE PRIMEIRO_NOME='João'";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE);

            statement.execute(maria);
            logger.info("Processo realizado com sucesso." + maria);

            statement.execute(joao);
            logger.info("Processo realizado com sucesso." + joao);

            statement.execute(pedro);
            logger.info("Processo realizado com sucesso." + pedro);

            statement.execute(update);
            statement.execute(delete);
            statement.execute(delete2);



        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();

        }finally {
            connection.close();
        }

    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test03", "sa","");
    }



}
