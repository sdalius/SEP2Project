package PatientBookingGUI.viewmodel.login;

import PatientBookingGUI.model.BookingClientInterface;

public class LoginViewModel {

    private BookingClientInterface bookingClient;

    public LoginViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
