package Server;

import shared.Patient;
import shared.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    String createAccount(Patient patient) throws RemoteException;
    User logIn(String username, String password) throws RemoteException;
}
