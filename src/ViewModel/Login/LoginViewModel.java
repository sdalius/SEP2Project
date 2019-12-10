package ViewModel.Login;

import Model.BookingClientInterface;
import Shared.User;

import java.rmi.RemoteException;

public class LoginViewModel {

    private BookingClientInterface clientInterface;

    public LoginViewModel(BookingClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    public Object logIn(String username, String password)
    {
        System.out.println ("[LoginViewModel] Sending to client interface");
        Object usr = null;
        try {
            usr = clientInterface.logIn ( username,password );
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return usr;
    }
}
