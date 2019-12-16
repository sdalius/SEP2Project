package Database;

import Shared.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DeleteData {
    private Statement statement;
    private DatabaseAccessObject databaseObject;

    public DeleteData() {
        this.databaseObject = DatabaseAccessObject.getDatabaseObject ();
    }

    public void deleteAppointment(String date, String time)
    {
        try{
            statement = databaseObject.getC().createStatement();
            statement.executeUpdate ( "DELETE from \"sep2\".appointment\n" +
                    "Where appointment.appointmentdate = '"+date+"' AND appointment.appointmenttime = '"+time+"'" );
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
