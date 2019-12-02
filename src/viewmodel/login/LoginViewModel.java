package viewmodel.login;

import model.BookingClientInterface;

public class LoginViewModel {

    private BookingClientInterface bookingClient;

    public LoginViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
