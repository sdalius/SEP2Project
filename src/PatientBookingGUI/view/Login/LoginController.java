package PatientBookingGUI.view.Login;

import PatientBookingGUI.view.ViewHandler;
import PatientBookingGUI.viewmodel.login.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {
    @FXML
    Button btnCreateAccount;

    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    public void init(LoginViewModel managerView, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.loginViewModel = managerView;
        }

    public void openCreateAccountView(ActionEvent actionEvent) {
        viewHandler.openCreateAccountView ();
    }
}
