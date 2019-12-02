package viewmodel.login;

import model.AccountModelInterface;

public class LoginViewModel {

    private AccountModelInterface bookingClient;

    public LoginViewModel(AccountModelInterface bookingClient) {
        this.bookingClient= bookingClient;
    }
}
