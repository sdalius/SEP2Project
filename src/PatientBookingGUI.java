import model.AccountModel;
import model.AccountModelInterface;
import view.ViewHandler;
import viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PatientBookingGUI extends Application {

    @Override
    public void start(Stage stage) throws RemoteException, NotBoundException {
        AccountModelInterface bookingClient = new AccountModel();
        ViewModelFactory vmf = new ViewModelFactory(bookingClient);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.start();
    }
}
