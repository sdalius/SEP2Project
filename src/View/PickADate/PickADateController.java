package View.PickADate;

import View.ViewHandler;
import ViewModel.PickADate.PickADateViewModel;
import com.sun.javafx.scene.control.skin.DatePickerContent;
import com.sun.javafx.scene.control.skin.DatePickerSkin;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PickADateController {

    private PickADateViewModel pickadateviewmodel;
    private ViewHandler viewHandler;
    @FXML
    ComboBox<String> comboBoxList;
    @FXML
    Label lblStuff;
    @FXML
    DatePicker datapickAppointment;

    public void init(PickADateViewModel pickadateviewmodel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.pickadateviewmodel = pickadateviewmodel;
        comboBoxList.getItems().addAll(
                "8:30",
                "9:00",
                "9:30",
                "10:00",
                "10:30",
                "11:00",
                "11:30",
                "12:00",
                "12:30",
                "13:00",
                "13:30",
                "14:00",
                "14:30",
                "15:00"
        );
        comboBoxList.setPromptText("Select time");
    }


    public void changeLabel() {
        lblStuff.setText("Selected time " + comboBoxList.getSelectionModel().getSelectedItem() +
                " Selected date:" + datapickAppointment.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
