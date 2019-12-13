package View.PickADate;

import Shared.Appointment;
import View.ViewHandler;
import ViewModel.PickADate.PickADateViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
        datapickAppointment.setValue(LocalDate.now());
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
        datapickAppointment.setOnAction(event -> {

            System.out.println(datapickAppointment.getValue().toString());
        });
    }


    public void changeLabel() {
        lblStuff.setText("Selected time " + comboBoxList.getSelectionModel().getSelectedItem() +
                " Selected date:" + datapickAppointment.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(comboBoxList.getSelectionModel().getSelectedIndex());
        comboBoxList.getItems().remove(0);
    }

}
