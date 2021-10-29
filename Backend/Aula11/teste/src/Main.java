import java.sql.Connection;

public class Main {
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMAIS;" +
            "CREATE TABLE ANIMAIS(" +
            "ID INT PRIMARY KEY," +
            "NOME varchar(100) NOT NULL," +
            "TIPO varchar(100) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (1, 'Pancho', 'Cachorro')";
    private static final String SQL_INSERT2 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (2, 'Pillo', 'Cachorro')";
    private static final String SQL_INSERT3 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (3, 'Cepillo', 'Elegante')";
    private static final String SQL_INSERT4 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (4, 'Pepe', 'Cachorro')";
    private static final String SQL_INSERT5 = "INSERT INTO ANIMAIS (ID, NOME, TIPO) VALUES (5, 'Rolo', 'Cavalo')";

    private static final String SQL_DELETE = "DELETE FROM ANIMAIS WHERE ID=4";

    public static void main(String[] args) {
        Connection connection = null;

        try {

        } catch (Exception e) {

        } finally {
            connection.close();
        }

    }
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();

    }
}
