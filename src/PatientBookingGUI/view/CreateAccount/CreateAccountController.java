package PatientBookingGUI.view.CreateAccount;

import PatientBookingGUI.view.ViewHandler;
import PatientBookingGUI.viewmodel.CreateAccount.CreateAccountViewModel;
import PatientBookingGUI.viewmodel.login.LoginViewModel;

public class CreateAccountController {

    private CreateAccountViewModel createAccountViewModel;
    private ViewHandler viewHandler;

    public void init(CreateAccountViewModel createAccountViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.createAccountViewModel = createAccountViewModel;
        }
}
