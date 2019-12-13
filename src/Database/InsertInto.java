package Database;
import Shared.Doctor;
import Shared.Patient;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class InsertInto {
    private DatabaseAccessObject dbobj;
    private Statement statement;

    public InsertInto() {
        this.dbobj = DatabaseAccessObject.getDatabaseObject();
    }

    public String addPatient(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password) {
        try {
            statement = dbobj.getC().createStatement();
            System.out.println(statement.executeUpdate ( "INSERT INTO \"sep2\".patient(username, password, usertype, firstname, lastname, address, birthdate,phonenumber,email) VALUES('" + username+ "','" + password + "','Patient', '" + fname + "','" + lname + "','" + address + "','" + birthdate + "','" + phoneNo + "','" + eMail + "'" + ")" ));
            statement.close();
            return "Success";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String addAppointment(LocalDate date, int doctorID, int patientID) {
        try {
            statement = dbobj.getC().createStatement();
            System.out.println(statement.executeUpdate ( "INSERT INTO \"sep2\".appointment(AppointmentDate, DoctorUID, PatientUID) VALUES('" + date + "','" + doctorID + "','" + patientID + "','"));
            statement.close();
            return "Success";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}