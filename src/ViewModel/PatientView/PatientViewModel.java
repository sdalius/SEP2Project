package ViewModel.PatientView;

import Model.BookingClientInterface;
import Shared.Appointment;
import Shared.Patient;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class PatientViewModel {

    private BookingClientInterface bookingClient;
    private int userID;

    public PatientViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }
}
