package View.PickADate;

import Shared.Doctor;
import Shared.Patient;
import View.ViewHandler;
import ViewModel.Login.LoginViewModel;
import ViewModel.PickADate.PickADateViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class PickADateController {

    private PickADateViewModel pickadateviewmodel;
    private ViewHandler viewHandler;

    public void init(PickADateViewModel pickadateviewmodel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.pickadateviewmodel = pickadateviewmodel;
        }
}
