package Server;

import Database.GetData;
import Database.InsertInto;
import Shared.Doctor;
import Shared.Patient;
import Shared.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BookingServer implements ServerInterface{

    private InsertInto insertInto;
    private GetData getData;
    public BookingServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        insertInto = new InsertInto ();
        getData = new GetData ();
    }

    @Override
    public String createAccount(Patient patient) {
        System.out.println ("[BookingServer] I've received a patient with the name of:" + patient.getFname ());
        String msg = insertInto.addPatient ( patient );
        return msg;
    }

    public User logIn(String username, String password)
    {
        System.out.println ("[BookingServer] User username is : " + username);
        User usr = getData.getCustomerData ( username,password );
        return usr;
    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        System.out.println("Getting doctor list");
        return getData.getAllDoctors();
    }
}
