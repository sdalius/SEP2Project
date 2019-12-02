package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetData {
    private Statement statement;
    private DatabaseAccessObject databaseObject;

    public GetData() throws SQLException, ClassNotFoundException {
        this.databaseObject = DatabaseAccessObject.getDatabaseObject ();
    }

    public void getCustomerData() {
        try{
            statement = databaseObject.getC ().createStatement ();
            ResultSet rs = statement.executeQuery ( "SELECT * FROM \"SkiRental\".customer;" );
            while (rs.next ()) {
                String id = rs.getString ( "CustomerID" );
                String fname = rs.getString ( "FirstName" );
                String lname = rs.getString ( "LastName" );
                String address = rs.getString ( "Address" );
                String birthday = rs.getString ( "Birthday" );
                String phoneNo = rs.getString ( "PhoneNo" );
                String email = rs.getString ( "eMail" );

                System.out.println ( "CustomerID = " + id );
                System.out.println ( "FirstName = " + fname );
                System.out.println ( "LastName = " + lname );
                System.out.println ( "Address = " + address );
                System.out.println ( "Birthday = " + birthday );
                System.out.println ( "PhoneNo = " + phoneNo );
                System.out.println ( "eMail = " + email );
                System.out.println ();
            }
            rs.close ();
            statement.close ();
        }
        catch (Exception e)
        {
            System.err.println ( e.getClass ().getName () + ": " + e.getMessage () );
            System.exit ( 0 );
        }
        System.out.println ( "Database query ok"  );
    }
}

