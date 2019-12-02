package view.Login;

import view.ViewHandler;
import viewmodel.login.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {
    @FXML
    Button btnCreateAccount;

    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.loginViewModel = loginViewModel;
        }

    public void openCreateAccountView(ActionEvent actionEvent) {
        viewHandler.openCreateAccountView ();
    }
}
