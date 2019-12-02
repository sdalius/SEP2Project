package viewmodel;

import model.BookingClientInterface;
import viewmodel.CreateAccount.CreateAccountViewModel;
import viewmodel.login.LoginViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;

    public ViewModelFactory(BookingClientInterface bookingClientInterface) {
        loginViewModel = new LoginViewModel ( bookingClientInterface );
        createAccountViewModel = new CreateAccountViewModel ( bookingClientInterface );
    }
    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
    public CreateAccountViewModel getCreateAccountViewModel() { return createAccountViewModel;}
}
