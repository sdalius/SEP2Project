package PatientBookingGUI.viewmodel;

import PatientBookingGUI.model.BookingClientInterface;
import PatientBookingGUI.viewmodel.CreateAccount.CreateAccountViewModel;
import PatientBookingGUI.viewmodel.login.LoginViewModel;

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
