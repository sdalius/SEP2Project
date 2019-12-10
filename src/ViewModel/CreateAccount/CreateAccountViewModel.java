package ViewModel.CreateAccount;

import Model.BookingClientInterface;
import View.ViewHandler;

import java.rmi.RemoteException;

public class CreateAccountViewModel {
    private BookingClientInterface bookingClient;

    public CreateAccountViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public void createAccount(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password ) {
        System.out.println ("[CreateAccountViewModel] We got a patient with a name of: " + fname);
        System.out.println ("[CreateAccountViewModel] Sending to Booking Client");
        try { bookingClient.createAccount(fname, lname, username, address, birthdate, phoneNo, eMail, password);

        } catch (RemoteException e) {
            e.printStackTrace ();
        }
    }
    public void goBackToMain(ViewHandler vh)
    {
        vh.openLoginView ();
    }
}
