package Database;

import Shared.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
            databaseObject.setSearchPath ( "sep2" );
            statement = databaseObject.getC ().createStatement ();
            ResultSet rs = statement.executeQuery ( "Select * from \"sep2\".users\n" +
                    "Where users.username LIKE '"+username+"' AND users.password LIKE '"+password+"'" );
            if(rs.isBeforeFirst () == false)
            {
                return null;
            }
            else {
                while (rs.next ()) {
                    id = rs.getInt ( "userid" );
                    username1 = rs.getString ( "username" );
                    String password1 = rs.getString ( "password" );
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
        return new User(id,username1,usertype);
    }
}

