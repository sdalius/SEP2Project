package viewmodel;

import model.BookingClientInterface;
import viewmodel.CreateAccount.CreateAccountViewModel;
import viewmodel.PatientView.PatientViewModel;
import viewmodel.login.LoginViewModel;

public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private PatientViewModel patientViewModel;

    public ViewModelFactory(BookingClientInterface bookingClientInterface) {
        loginViewModel = new LoginViewModel ( bookingClientInterface );
        createAccountViewModel = new CreateAccountViewModel ( bookingClientInterface );
        patientViewModel = new PatientViewModel ( bookingClientInterface );
    }
    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }
    public CreateAccountViewModel getCreateAccountViewModel() { return createAccountViewModel;}
    public PatientViewModel getPatientViewModel() { return patientViewModel;}
}
