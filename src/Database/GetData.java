package Database;

import Shared.Appointment;
import Shared.Doctor;
import Shared.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class GetData {
    private Statement statement;
    private DatabaseAccessObject databaseObject;
    HashMap<Integer, Patient> patients = new HashMap<>();

    public GetData() {
        this.databaseObject = DatabaseAccessObject.getDatabaseObject ();
    }

    public Object getCustomerData(String username, String password) {
        int id = 0;
        String usertype = "";
        try{
            statement = databaseObject.getC ().createStatement ();
            ResultSet rs = statement.executeQuery ( "Select * from \"sep2\".users\n" +
                    "Where users.username LIKE '"+username+"' AND users.password LIKE '"+password+"'" );
            if(!rs.isBeforeFirst ())
            {
                return null;
            }
            else{
                while (rs.next ())
                {
                    id = rs.getInt ( "userid" );
                    usertype = rs.getString ( "usertype" );
                    System.out.println("[GETDATA] + Usertype: " + usertype);
                }
                if (usertype.equals ("Patient"))
                {
                    ResultSet patient = statement.executeQuery ( "Select firstname,lastname,address,birthdate,phonenumber,email from \"sep2\".patient\n" +
                            "Where patient.userid = '"+id+"'");
                    while (patient.next ())
                    {
                        String firstname = patient.getString ("firstname");
                        String lastname = patient.getString ("lastname");
                        String address = patient.getString ("address");
                        String birthdate = patient.getString ("birthdate");
                        String phoneno = patient.getString ("phonenumber");
                        String email = patient.getString ("email");
                        Patient patientobj = new Patient (id,firstname,lastname,address,birthdate,phoneno,email);
                        return patientobj;
                    }
                }
                else if(usertype.equals("Doctor"))
                {
                    ResultSet doctor = statement.executeQuery ( "Select firstname,lastname,officenumber,phonenumber,email from \"sep2\".doctor\n" +
                            "Where doctor.userid = '"+id+"'");
                    while (doctor.next())
                    {
                        String firstname = doctor.getString ("firstname");
                        String lastname = doctor.getString ("lastname");
                        int officenumber = doctor.getInt ("officenumber");
                        String phoneno = doctor.getString ("phonenumber");
                        String email = doctor.getString ("email");
                        Doctor doctorobj = new Doctor (id,firstname,lastname,phoneno,email,officenumber);
                        return doctorobj;
                    }
                }
            }
            rs.close ();
            statement.close ();
        }
        catch (SQLException e)
        {
            e.getMessage ();
        }
        return null;
    }
    public ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> doctorArr = new ArrayList<> ();
        try {
            statement = databaseObject.getC().createStatement ();
            ResultSet rs = statement.executeQuery ( "Select * from \"sep2\".doctor\n" );
            while (rs.next ()) {
                int id = rs.getInt ( "userid" );
                String firstname = rs.getString ( "firstname" );
                String lastname = rs.getString ( "lastname" );
                int officenumber = rs.getInt ( "officenumber" );
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

    public ArrayList<Appointment> getAppointmentsAccordingToDate(String date)
    {
        ArrayList<Appointment>appArr = new ArrayList<>();
        try{
                statement = databaseObject.getC().createStatement();
                ResultSet appSet = statement.executeQuery("Select * from \"sep2\".appointment\n" +
                        "where appointmentdate = '"+date+"'");
                if(!appSet.isBeforeFirst ())
                {
                    return null;
                }
                else{
                    while (appSet.next ()) {
                        appArr.add ( new Appointment ( appSet.getString ("appointmentdate"), appSet.getInt ("doctoruid"), appSet.getInt ("patientuid"), appSet.getString("appointmenttime")) );
                    }
                }
                appSet.close ();
                statement.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
            return appArr;
         }

    public ArrayList<Appointment> getAppointmentsAccordingToDateAndDoctorID(String date,int doctorID)
    {
        System.out.println("Date: " + date + "\n"
        + "Doctor ID: "+ doctorID);
        ArrayList<Appointment>appArr = new ArrayList<>();
        appArr.clear();
        try{
            statement = databaseObject.getC().createStatement();
            ResultSet appSet = statement.executeQuery("Select * from \"sep2\".appointment\n" +
                    "where appointmentdate = '"+date+"' AND doctoruid = '"+doctorID+"'");
            if(!appSet.isBeforeFirst ())
            {
                return null;
            }
            else{
                while (appSet.next ()) {
                    appArr.add ( new Appointment ( appSet.getString ("appointmentdate"), appSet.getInt ("doctoruid"), appSet.getInt ("patientuid"), appSet.getString("appointmenttime")) );
                    System.out.println(appSet.getString("appointmentdate"));
                }
            }
            appSet.close ();
            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return appArr;
    }

    public Patient getPatientByID(int id) {
        Patient patientfromhash = patients.get(id);
        if(patientfromhash == null) {
            try {
                statement = databaseObject.getC().createStatement();
                ResultSet patient = statement.executeQuery("Select firstname,lastname,address,birthdate,phonenumber,email from \"sep2\".patient\n" +
                        "Where patient.userid = '" + id + "'");
                while(patient.next()) {
                    System.out.println("Patient ID: " + patient.getString("firstname"));
                    patientfromhash = new Patient(id, patient.getString("firstname"),
                                    patient.getString("lastname"),
                            patient.getString("address"),
                            patient.getString("birthdate"),
                            patient.getString("phonenumber"),
                            patient.getString("email"));
                }
                patients.put(id, patientfromhash);
                patient.close();
                statement.close();
            } catch(SQLException e) {
                return null;
            }
        }
        return patientfromhash;
    }
}

