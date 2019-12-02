package Database;

import javafx.scene.control.Alert;
import shared.Patient;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertInto {
    private DatabaseAccessObject dbobj;
    private Statement statement;

    public InsertInto() {
        this.dbobj = DatabaseAccessObject.getDatabaseObject ();
        setSearchPath ( "sep2" );
    }

    public void setSearchPath(String schemaName) {
        try {
            statement = dbobj.getC ().createStatement ();
            statement.executeUpdate ( "set search_path = \"" + schemaName + "\";" );
            System.out.println ( "Setting search path to " + schemaName );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void addPatient(Patient patient) {
        try {
            statement = dbobj.getC ().createStatement ();
            statement.executeUpdate ( "INSERT INTO \"sep2\".patient(username, password, usertype, firstname, lastname, address, birthdate,phonenumber,email) VALUES('" + patient.getCpr () + "','" + patient.getPassword () + "','Patient', '" + patient.getFname () + "','" + patient.getLname () + "','" + patient.getAddress () + "','" + patient.getBirthdate () + "','" + patient.getPhoneNo () + "','" + patient.getEmail () + "'" + ")" );
            statement.close ();
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Create Account");
            alert.setHeaderText(null);
            alert.setContentText("Account has been created!");
            alert.showAndWait();

        } catch (SQLException e) {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle("Create Account Error!");
            alert.setHeaderText("Error!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}