package ViewModel.Doctor;

import Model.BookingClientInterface;
import Shared.Doctor;

import java.rmi.RemoteException;

public class DoctorViewModel {
    private BookingClientInterface bookingClient;
    private Doctor doctor;

    public DoctorViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public void setDoctor()
    {
        try {
            this.doctor = (Doctor) bookingClient.getUsr();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public Doctor getUser() {
        return doctor;
    }
}
