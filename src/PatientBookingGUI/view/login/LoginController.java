package PatientBookingGUI.view.login;

import PatientBookingGUI.view.ViewHandler;
import PatientBookingGUI.viewmodel.login.LoginViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ViewHandler;
import viewmodel.login.LoginViewModel;

import java.rmi.RemoteException;

public class LoginController {
    @FXML
    Button btnCloseBar;

    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    public void closebar() throws RemoteException, InterruptedException {
            managerViewModel.closeBar();
            Platform.exit();
    }
    public void init(LoginViewModel managerView, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.loginViewModel = managerView;
        }
}
