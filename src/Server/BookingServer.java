package Server;

import Database.DeleteData;
import Database.GetData;
import Database.InsertInto;
import Shared.Appointment;
import Shared.Doctor;
import Shared.Patient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BookingServer implements ServerInterface{

    private InsertInto insertInto;
    private GetData getData;
    private DeleteData deleteData;
    public BookingServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        insertInto = new InsertInto ();
        getData = new GetData ();
        deleteData = new DeleteData();
    }

    @Override
    public String createAccount(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password) {
        System.out.println ("[BookingServer] I've received a patient with the name of: " + fname);
        String msg = insertInto.addPatient ( fname, lname, username, address,birthdate, phoneNo, eMail,password );
        System.out.println(msg);
        return msg;
    }

    @Override
    public Object logIn(String username, String password)
    {
        System.out.println ("[BookingServer] Username is: " + username);
        return getData.getCustomerData (username, password);

    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        System.out.println("Getting doctor list");
        return getData.getAllDoctors();
    }

    public ArrayList<Appointment> getAppointmentsAccordingToDate(String date) {
        return getData.getAppointmentsAccordingToDate(date);
    }

    public ArrayList<Appointment> getAppointmentsAccordingToDateAndDoctorID(String date,int doctorID) {
        return getData.getAppointmentsAccordingToDateAndDoctorID(date,doctorID);
    }

    @Override
    public String addAppointment(String date, int doctorID, int patientID, String appointmenttime) throws RemoteException {
        return insertInto.addAppointment(date, doctorID, patientID,appointmenttime);
    }

    public Patient getPatientByID(int id)
    {
        return getData.getPatientByID(id);
    }

    public void deleteAppointment(String date, String time)
    {
        deleteData.deleteAppointment(date,time);
    }
}
