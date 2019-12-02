package viewmodel.CreateAccount;

import model.AccountModelInterface;

public class CreateAccountViewModel {
    private AccountModelInterface bookingClient;

    public CreateAccountViewModel(AccountModelInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
