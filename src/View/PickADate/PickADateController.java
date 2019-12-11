package View.PickADate;

import View.ViewHandler;
import ViewModel.PickADate.PickADateViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class PickADateController {

    @FXML
    ComboBox<String> comboBoxList;
    @FXML
    Label timeLabel;
    @FXML
    Label dateLabel;
    @FXML
    DatePicker appointmentDatePicker;

    public void init(PickADateViewModel pickadateviewmodel, ViewHandler viewHandler) {
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

    public void updateTimeLabel() {
        timeLabel.setText("Selected time: " + comboBoxList.getSelectionModel().getSelectedItem());
    }

    public void updateDateLabel() {
        dateLabel.setText("Selected date: " + appointmentDatePicker.getValue());
    }

    public void bookAppointment() {
        return;
    }
}
