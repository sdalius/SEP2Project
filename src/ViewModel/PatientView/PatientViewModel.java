package ViewModel.PatientView;

import Model.BookingClientInterface;

public class PatientViewModel {

    private BookingClientInterface bookingClient;

    public PatientViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
