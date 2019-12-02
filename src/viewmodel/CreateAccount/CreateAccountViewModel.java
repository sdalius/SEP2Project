package viewmodel.CreateAccount;

import model.BookingClientInterface;

public class CreateAccountViewModel {
    private BookingClientInterface bookingClient;

    public CreateAccountViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
