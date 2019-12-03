package view.CreateAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shared.Patient;
import view.ViewHandler;
import viewmodel.CreateAccount.CreateAccountViewModel;

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
        createAccountViewModel.createAccount(new Patient(txtfname.getText(), txtlname.getText(), txtcpr.getText(), txtaddress.getText(), txtbirthdate.getText(), txtphone.getText(), txtemail.getText(), txtpassword.getText()));
    }
}
