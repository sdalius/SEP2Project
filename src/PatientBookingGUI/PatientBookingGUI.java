package PatientBookingGUI;

import PatientBookingGUI.model.BookingClient;
import PatientBookingGUI.model.BookingClientInterface;
import PatientBookingGUI.view.ViewHandler;
import PatientBookingGUI.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PatientBookingGUI extends Application {

    @Override
    public void start(Stage stage) throws RemoteException, NotBoundException {
        BookingClientInterface bookingClient = new BookingClient ();
        ViewModelFactory vmf = new ViewModelFactory(bookingClient);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
