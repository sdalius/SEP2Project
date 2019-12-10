package Database;

import Shared.Doctor;
import Shared.Patient;

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
                }
                if (usertype.equals ("Patient"))
                {
                    ResultSet patient = statement.executeQuery ( "Select userid,usertype,firstname,lastname,address,birthdate,phonenumber,email from \"sep2\".patient\n" +
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
                else if(usertype == "Doctor")
                {
                    ResultSet doctor = statement.executeQuery ( "Select userid,usertype,firstname,lastname,officenumber,phonenumber,email from \"sep2\".doctor\n" +
                            "Where doctor.userid LIKE '"+id+"'");
                    while (rs.next())
                    {
                        String firstname = doctor.getString ("firstname");
                        String lastname = doctor.getString ("lastname");
                        int officenumber = doctor.getInt ("officenumber");
                        String phoneno = doctor.getString ("phoneNo");
                        String email = doctor.getString ("email");
                        Doctor doctorobj = new Doctor (id,firstname,lastname,phoneno,email,officenumber);
                        return doctorobj;
                    }
                }
            }
            rs.close ();
            statement.close ();
            databaseObject.getC ().close ();
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
            databaseObject.getC().close();
        } catch (SQLException e) {
            e.getMessage ();
        }
        return doctorArr;
    }
}

