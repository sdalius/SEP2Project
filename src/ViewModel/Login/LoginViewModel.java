package ViewModel.Login;

import Model.BookingClientInterface;
import Shared.User;

import java.rmi.RemoteException;

public class LoginViewModel {

    private BookingClientInterface bookingClient;

    public LoginViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public User logIn(String username, String password)
    {
        System.out.println ("[LoginViewModel] Sending to bookingClient");
        User usr = null;
        try {
            usr = bookingClient.logIn ( username,password );
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return usr;
    }
}
