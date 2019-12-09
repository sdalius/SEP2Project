package Database;
import Shared.Doctor;
import Shared.Patient;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertInto {
    private DatabaseAccessObject dbobj;
    private Statement statement;

    public InsertInto() {
        this.dbobj = DatabaseAccessObject.getDatabaseObject ();
        dbobj.setSearchPath ( "sep2" );
    }

    public String addPatient(Patient patient) {
        System.out.println (patient.getLname ());
        try {
            statement = dbobj.getC ().createStatement ();
            System.out.println (statement.executeUpdate ( "INSERT INTO \"sep2\".patient(username, password, usertype, firstname, lastname, address, birthdate,phonenumber,email) VALUES('" + patient.getCpr () + "','" + patient.getPassword () + "','Patient', '" + patient.getFname () + "','" + patient.getLname () + "','" + patient.getAddress () + "','" + patient.getBirthdate () + "','" + patient.getPhoneNo () + "','" + patient.getEmail () + "'" + ")" ));
            System.out.println ("Code has been executed");
            System.out.println ("Am i here?");
            statement.close ();
            return "Success!" ;
        } catch (SQLException e) {
            return e.getMessage();
        }

    }
}