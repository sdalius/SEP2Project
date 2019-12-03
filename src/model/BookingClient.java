package model;

import Server.ServerInterface;
import javafx.scene.control.Alert;
import shared.Patient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookingClient implements BookingClientInterface {
    private ServerInterface serverInterface;

    public BookingClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost",1099);
        serverInterface = (ServerInterface) registry.lookup("BookingServer");
    }

    @Override
    public void createAccount(Patient patient) {
        System.out.println ("[BookingClient] I've received a patient with a name of:" + patient.getFname ());
        try {
            String errmsg = serverInterface.createAccount ( patient );
            System.out.println ("[BookingClient] Sending object to the server Interface");
            if (errmsg != "Success")
            {
                Alert alert = new Alert( Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText(errmsg);
                alert.showAndWait();
            }
            else{
                Alert alert = new Alert( Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Look, an Information Dialog");
                alert.setContentText("Account has been created!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
