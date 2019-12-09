package Database;

import Shared.Doctor;
import Shared.User;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GetData {
    private Statement statement;
    private DatabaseAccessObject databaseObject;

    public GetData() {
        this.databaseObject = DatabaseAccessObject.getDatabaseObject ();
    }

    public User getCustomerData(String username, String password) {
        int id = 0;
        String username1 = null;
        String usertype = null;
        try{
            statement = databaseObject.getC ().createStatement ();
            ResultSet rs = statement.executeQuery ( "Select * from \"sep2\".users\n" +
                    "Where users.username LIKE '"+username+"' AND users.password LIKE '"+password+"'" );
            if(!rs.isBeforeFirst ())
            {
                return null;
            }
            else {
                while (rs.next ())
                {
                    id = rs.getInt ( "userid" );
                    username1 = rs.getString ( "username" );
                    usertype = rs.getString ( "usertype" );
                }
            }
            rs.close ();
            statement.close ();
        }
        catch (SQLException e)
        {
            e.getMessage ();
        }
        final User user = new User ( id, username1, usertype );
        return user;
    }

    public ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> doctorArr = new ArrayList<> ();
        try {
            statement = databaseObject.getC ().createStatement ();
            ResultSet rs = statement.executeQuery ( "Select * from \"sep2\".doctor\n" );
            while (rs.next ()) {
                int id = rs.getInt ( "userid" );
                String firstname = rs.getString ( "firstname" );
                String lastname = rs.getString ( "lastname" );
                String officenumber = rs.getString ( "officenumber" );
                String phonenumber = rs.getString ( "phonenumber" );
                String email = rs.getString ( "email" );
                doctorArr.add ( new Doctor ( id, firstname, lastname, phonenumber, email, officenumber ) );
            }
            rs.close ();
            statement.close ();
        } catch (SQLException e) {
            e.getMessage ();
        }
        return doctorArr;
    }
}

