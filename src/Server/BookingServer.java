package Server;

import shared.Patient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BookingServer implements ServerInterface{

    public BookingServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public void createAccount(Patient patient) {

    }
}
