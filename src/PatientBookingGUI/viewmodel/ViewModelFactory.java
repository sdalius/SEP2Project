package PatientBookingGUI.viewmodel;

import PatientBookingGUI.model.BookingClientInterface;
import PatientBookingGUI.viewmodel.login.LoginViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;

    public ViewModelFactory(BookingClientInterface bookingClientInterface) {
        loginViewModel = new LoginViewModel ( bookingClientInterface );
    }
    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
}
