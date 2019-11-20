package PatientBookingGUI.view;

import PatientBookingGUI.view.login.LoginController;
import PatientBookingGUI.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory vmf;
    private Stage mainStage;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        this.vmf = vmf;
        mainStage = stage;
    }
    public void start() {
        openLoginView();
    }

    public void openLoginView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("login/loginView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginController controller = loader.getController();
        controller.init(vmf.getLoginViewModel (), this);
        mainStage.setTitle("Login View");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}