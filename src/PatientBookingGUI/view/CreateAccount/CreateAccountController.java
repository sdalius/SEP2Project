package PatientBookingGUI.view.CreateAccount;

import PatientBookingGUI.view.ViewHandler;
import PatientBookingGUI.viewmodel.login.LoginViewModel;

public class CreateAccountController {

    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    public void init(LoginViewModel managerView, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.loginViewModel = managerView;
        }
}
