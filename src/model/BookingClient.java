package model;

import Database.DatabaseAccessObject;
import Database.InsertInto;
import shared.Patient;

import java.rmi.RemoteException;

public class BookingClient implements BookingClientInterface {
    private DatabaseAccessObject dbobj;
    private InsertInto insertInto;

    public BookingClient()
    {
        dbobj = DatabaseAccessObject.getDatabaseObject();
        insertInto = new InsertInto ();
    }

    @Override
    public void createAccount(Patient patient) {
        insertInto.addPatient ( patient );
    }
}
