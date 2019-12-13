package View.CreateAccount;

import Shared.Patient;
import View.ViewHandler;
import ViewModel.CreateAccount.CreateAccountViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CreateAccountController {
    @FXML
    TextField txtfname;
    @FXML
    TextField txtlname;
    @FXML
    TextField txtcpr;
    @FXML
    TextField txtaddress;
    @FXML
    TextField txtphone;
    @FXML
    TextField txtemail;
    @FXML
    TextField txtpassword;
    @FXML
    TextField txtbirthdate;

    private CreateAccountViewModel createAccountViewModel;
    private ViewHandler viewHandler;

    public void init(CreateAccountViewModel createAccountViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.createAccountViewModel = createAccountViewModel;
        }

    public void goBackToMain() {
        createAccountViewModel.goBackToMain(viewHandler);
    }

    public void createAccount() {
        String errmsg = createAccountViewModel.createAccount(txtfname.getText(), txtlname.getText(), txtcpr.getText(), txtaddress.getText(), txtbirthdate.getText(), txtphone.getText(), txtemail.getText(), txtpassword.getText());
        if (errmsg != "Success") {
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle ("Account info");
            alert.setHeaderText (null);
            alert.setContentText (errmsg);
            alert.showAndWait ();
        } else {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle ("Account info");
            alert.setHeaderText (null);
            alert.setContentText ("Account has been created!");
            alert.showAndWait ();
        }
    }
}
