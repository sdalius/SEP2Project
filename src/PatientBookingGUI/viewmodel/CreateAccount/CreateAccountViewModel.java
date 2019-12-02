package PatientBookingGUI.viewmodel.CreateAccount;

import PatientBookingGUI.model.BookingClientInterface;

public class CreateAccountViewModel {
    private BookingClientInterface bookingClient;

    public CreateAccountViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
