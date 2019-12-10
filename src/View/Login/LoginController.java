package View.Login;

import Shared.Doctor;
import Shared.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import Shared.User;
import View.ViewHandler;
import ViewModel.Login.LoginViewModel;

public class LoginController {
    @FXML
    Button btnCreateAccount;
    @FXML
    TextField txtfieldUsername;
    @FXML
    TextField txtfieldPassword;

    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    public void init(LoginViewModel loginViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.loginViewModel = loginViewModel;
        }

    public void openCreateAccountView() {
        viewHandler.openCreateAccountView ();
    }

    public void logIn() {
        System.out.println ("[LoginController]Sending to login view model");
        Object msg = loginViewModel.logIn ( txtfieldUsername.getText (),txtfieldPassword.getText () );
        if(msg == null)
        {
            Alert alert = new Alert( Alert.AlertType.ERROR);
            alert.setTitle("Account info");
            alert.setHeaderText(null);
            alert.setContentText("This account is not existing.");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert( Alert.AlertType.INFORMATION);
            alert.setTitle("Account info");
            alert.setHeaderText(null);
            alert.setContentText("Successfully logged in!");
            alert.showAndWait();
            if (alert.getResult () == ButtonType.OK) {
                if (msg instanceof Patient)
                {
                    viewHandler.openPatientView (msg);
                }
                else if (msg instanceof Doctor)
                {
                    viewHandler.openDoctorView();
                }
            }
        }
    }
}
