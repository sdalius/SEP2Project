package viewmodel.PatientView;

import model.BookingClientInterface;

public class PatientViewModel {

    private BookingClientInterface bookingClient;

    public PatientViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
