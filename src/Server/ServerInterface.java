package Server;

import Shared.Doctor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote {
    String createAccount(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password) throws RemoteException;
    Object logIn(String username, String password) throws RemoteException;
    ArrayList<Doctor> getDoctorList() throws RemoteException;
}
