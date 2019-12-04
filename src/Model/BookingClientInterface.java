package Model;

import Shared.Patient;
import Shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookingClientInterface extends Remote {
    void createAccount(Patient patient) throws RemoteException;
    User logIn(String username, String password) throws RemoteException;
}
