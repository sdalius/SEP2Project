import javafx.application.Application;
import javafx.stage.Stage;
import model.BookingClient;
import model.BookingClientInterface;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PatientBookingGUI extends Application {

    @Override
    public void start(Stage stage) {
        BookingClientInterface bookingClient = null;
        try {
            bookingClient = new BookingClient ();
        } catch (RemoteException e) {
            e.printStackTrace ();
        } catch (NotBoundException e) {
            e.printStackTrace ();
        }
        ViewModelFactory vmf = new ViewModelFactory(bookingClient);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
