package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccessObject {
    private Connection connection;
    private static DatabaseAccessObject instance;

    private DatabaseAccessObject() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://185.80.129.145:5432/postgres",
                        "sep2stuff", "sep22009");
        System.out.println("Database open ok");
    }

    public static DatabaseAccessObject getDatabaseObject() throws SQLException, ClassNotFoundException {
        if (instance == null)
        {
            instance = new DatabaseAccessObject ();
        }
        return instance;
    }

    public void closeConnection() throws SQLException {
        connection.close();
        System.out.println ("Connection has been closed.");
    }

    public Connection getConnection() {
        return connection;
    }

}
