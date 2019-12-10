package ViewModel.PatientView;

import Model.BookingClientInterface;
import Shared.Patient;

public class PatientViewModel {

    private BookingClientInterface bookingClient;
    private Object user;

    public PatientViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public void setUser(Object usr)
    {
        this.user = usr;
    }
}
