package Server;

import shared.Patient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    void createAccount(Patient patient) throws RemoteException;
}
