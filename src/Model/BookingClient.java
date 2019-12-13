package Model;

import Server.ServerInterface;
import Shared.Appointment;
import Shared.Doctor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class BookingClient implements BookingClientInterface {
    private ServerInterface serverInterface;

    public BookingClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry ("localhost", 1099);
        serverInterface = (ServerInterface) registry.lookup ("BookingServer");
    }

    @Override
    public String createAccount(String fname, String lname, String username, String address, String birthdate, String phoneNo, String eMail, String password) {
        String errmsg = "";
        System.out.println ("[BookingClient] I've received a patient with a name of:" + fname);
        try {
            errmsg = serverInterface.createAccount (fname, lname, username, address,birthdate, phoneNo, eMail,password);
            System.out.println ("[BookingClient] Sending object to the server Interface");
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return errmsg;
    }

    @Override
    public Object logIn(String username, String password) {
        Object usr = null;
        try {
            usr = serverInterface.logIn (username, password);
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return usr;
    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        ArrayList<Doctor> doctorList = new ArrayList<> ();
        try {
            doctorList = serverInterface.getDoctorList ();
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return doctorList;
    }
    public ArrayList<Appointment> getAppointmentListAccordingToDate(String date)
    {
        ArrayList<Appointment> appointmentsAccordingToDate = new ArrayList<>();
        try {
            appointmentsAccordingToDate = serverInterface.getAppointmentsAccordingToDate(date);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return appointmentsAccordingToDate;
    }
}


