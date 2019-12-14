package ViewModel.Doctor;

import Model.BookingClientInterface;

import java.rmi.RemoteException;

public class DoctorViewModel {
    private BookingClientInterface bookingClient;

    public DoctorViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public String createAccount(String fname, String lname, String username, String address, String birthdate, String phoneNo, String eMail, String password ) {
        String errmsg = "";
        System.out.println ("[CreateAccountViewModel] We got a patient with a name of: " + fname);
        System.out.println ("[CreateAccountViewModel] Sending to Booking Client");
        try { errmsg = bookingClient.createAccount(fname, lname, username, address, birthdate, phoneNo, eMail, password);

        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return errmsg;
    }
}
