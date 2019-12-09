package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAccessObject {
    private Statement statement;
    private Connection c;
    private static DatabaseAccessObject instance;

    private DatabaseAccessObject() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://185.80.129.145:5432/sep2project",
                            "sep2stuff", "sep22009");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace ();
        }
        System.out.println("Database open ok");
        setSearchPath ( "sep2" );
    }

    public static DatabaseAccessObject getDatabaseObject() {
        if (instance == null)
        {
            instance = new DatabaseAccessObject ();
        }
        return instance;
    }

    public void closeConnection() {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        System.out.println ("Connection has been closed.");
    }

    public void setSearchPath(String schemaName) {
        try {
            statement = c.createStatement ();
            System.out.println (statement.executeUpdate ( "set search_path = \"" + schemaName + "\";" ));
            System.out.println ( "Setting search path to " + schemaName );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public Connection getC() {
        return c;
    }

}
