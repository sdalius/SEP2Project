package Database;

import java.sql.SQLException;
import java.text.ParseException;

public class MainDatabase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        DatabaseAccessObject dbobj = DatabaseAccessObject.getDatabaseObject();
        dbobj.closeConnection ();
    }
}
