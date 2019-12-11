package Model;

import Server.ServerInterface;
import Shared.Doctor;
import javafx.scene.control.Alert;
import Shared.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class BookingClient implements BookingClientInterface {
    private ServerInterface serverInterface;

    public BookingClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry ("localhost", 1099);
        serverInterface = (ServerInterface) registry.lookup ("BookingServer");
    }

    @Override
    public void createAccount(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password) {
        System.out.println ("[BookingClient] I've received a patient with a name of:" + fname);
        try {
            String errmsg = serverInterface.createAccount (fname, lname, username, address,birthdate, phoneNo, eMail,password);
            System.out.println ("[BookingClient] Sending object to the server Interface");
            if (errmsg != "Success") {
                Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setTitle ("Account info");
                alert.setHeaderText (null);
                alert.setContentText (errmsg);
                alert.showAndWait ();
            } else {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setTitle ("Account info");
                alert.setHeaderText (null);
                alert.setContentText ("Account has been created!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    @Override
    public Object logIn(String username, String password) {
        Object usr = null;
        try {
            usr = serverInterface.logIn (username, password);
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return usr;
    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        ArrayList<Doctor> doctorList = new ArrayList<> ();
        try {
            doctorList = serverInterface.getDoctorList ();
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return doctorList;
    }
}


