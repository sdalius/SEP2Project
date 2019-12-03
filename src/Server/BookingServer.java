package Server;

import Database.InsertInto;
import shared.Patient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class BookingServer implements ServerInterface{

    private InsertInto insertInto;
    public BookingServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
        insertInto = new InsertInto();
    }

    @Override
    public String createAccount(Patient patient) {
        System.out.println ("[BookingServer] I've received a patient with the name of:" + patient.getFname ());
        return insertInto.addPatient ( patient );
    }
}
