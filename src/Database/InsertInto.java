package Database;

import java.sql.SQLException;
import java.sql.Statement;

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

    public String addAppointment(String date, int doctorID, int patientID,String appointmenttime) {
        try {
            statement = dbobj.getC().createStatement();
            statement.executeUpdate ( "INSERT INTO \"sep2\".appointment(AppointmentDate, DoctorUID, PatientUID, appointmenttime) VALUES('" + date + "','" + doctorID + "','" + patientID + "','" + appointmenttime + "'" + ")");
            statement.close();
            return "Success";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String updateAppointment(String olddate, String oldappointmenttime ,String newdate, String newappointmenttime)
    {
        try {
            statement = dbobj.getC().createStatement();
            statement.executeUpdate ( "UPDATE \"sep2\".appointment SET appointmentdate = '"+newdate+"' , appointmenttime = '"+newappointmenttime+"' " +
                            "WHERE appointmentdate = '"+olddate+"' AND appointmenttime = '"+oldappointmenttime+"'" );
            statement.close();
            return "Success";
        } catch (SQLException e) {
           return e.getMessage();
        }
    }
}