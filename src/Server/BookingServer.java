package Server;

import Database.GetData;
import Database.InsertInto;
import Shared.Doctor;

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
    public String createAccount(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password) {
        System.out.println ("[BookingServer] I've received a patient with the name of:" + fname);
        String msg = insertInto.addPatient ( fname, lname, username, address,birthdate, phoneNo, eMail,password );
        return msg;
    }

    public Object logIn(String username, String password)
    {
        System.out.println ("[BookingServer] User username is : " + username);
        Object usr = getData.getCustomerData ( username,password );
        return usr;
    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        System.out.println("Getting doctor list");
        return getData.getAllDoctors();
    }
/*
    @Override
    public void bookAppointment() {
        insertInto
    }*/
}
