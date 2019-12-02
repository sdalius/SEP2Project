import javafx.application.Application;
import javafx.stage.Stage;
import model.BookingClient;
import model.BookingClientInterface;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class PatientBookingGUI extends Application {

    @Override
    public void start(Stage stage) {
        BookingClientInterface bookingClient = new BookingClient ();
        ViewModelFactory vmf = new ViewModelFactory(bookingClient);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
