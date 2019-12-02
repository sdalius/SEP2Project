package model;

import shared.Patient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookingClientInterface extends Remote {
    void createAccount(Patient patient) throws RemoteException;
}
