package RMIServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BookingServer implements ServerInterface{

    public BookingServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }
}
