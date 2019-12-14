package ViewModel.PatientView;

import Model.BookingClientInterface;
import Shared.Patient;

import java.rmi.RemoteException;

public class PatientViewModel {

    private BookingClientInterface bookingClient;
    private Patient user;

    public PatientViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public void setPatient()
    {
        try {
            this.user = (Patient) bookingClient.getUsr();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public Patient getUser() {
        return user;
    }
}
