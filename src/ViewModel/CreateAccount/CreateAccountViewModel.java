package ViewModel.CreateAccount;

import Model.BookingClientInterface;
import Shared.Patient;
import View.ViewHandler;

import java.rmi.RemoteException;

public class CreateAccountViewModel {
    private BookingClientInterface bookingClient;

    public CreateAccountViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public void createAccount(Patient patient) {
        System.out.println ("[CreateAccountViewModel] We got a patient with a name of: " + patient.getFname ());
        System.out.println ("[CreateAccountViewModel] Sending to Booking Client");
        try { bookingClient.createAccount(patient);

        } catch (RemoteException e) {
            e.printStackTrace ();
        }
    }
    public void goBackToMain(ViewHandler vh)
    {
        vh.openLoginView ();
    }
}
