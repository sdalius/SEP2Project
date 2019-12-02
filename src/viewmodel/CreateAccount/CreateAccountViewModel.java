package viewmodel.CreateAccount;

import model.BookingClientInterface;
import shared.Patient;

import java.rmi.RemoteException;

public class CreateAccountViewModel {
    private BookingClientInterface bookingClient;

    public CreateAccountViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public void createAccount(Patient patient) {
        try { bookingClient.createAccount(patient);
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
    }
}
