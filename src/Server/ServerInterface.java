package Server;

import Shared.Doctor;
import Shared.Patient;
import Shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote {
    String createAccount(Patient patient) throws RemoteException;
    User logIn(String username, String password) throws RemoteException;
    ArrayList<Doctor> getDoctorList() throws RemoteException;
}
