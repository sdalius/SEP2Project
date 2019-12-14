package View.PickADate;

import Shared.Appointment;
import View.ViewHandler;
import ViewModel.PickADate.PickADateViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.util.ArrayList;

public class PickADateController {

    @FXML
    ComboBox<String> comboBoxList;
    @FXML
    DatePicker appointmentDatePicker;
    private PickADateViewModel pickADateViewModel;
    private ViewHandler viewHandler;

    public void init(PickADateViewModel pickadateviewmodel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.pickADateViewModel = pickadateviewmodel;
        comboBoxList.setPromptText("Select time");
    }

    public void selectDate()
    {
            ArrayList<Appointment> appArr = pickADateViewModel.getAppointmentsAccordingToDate(appointmentDatePicker.getValue().toString());
            if (appArr == null)
            {
                System.out.println("We dont have anything booked at this date");
                reupdateTimes();
            }
            else{
                removeTimeFromList(appArr);
            }
            System.out.println("Date picked:" + appointmentDatePicker.getValue().toString());
    }

    public void reupdateTimes()
    {
        comboBoxList.getItems().clear();
        comboBoxList.getItems().addAll(
                "08:30:00",
                "09:00:00",
                "09:30:00",
                "10:00:00",
                "10:30:00",
                "11:00:00",
                "11:30:00",
                "12:00:00",
                "12:30:00",
                "13:00:00",
                "13:30:00",
                "14:00:00",
                "14:30:00",
                "15:00:00"
        );
    }

    public void removeTimeFromList(ArrayList<Appointment> appArr)
    {
        reupdateTimes();
        for(int i = 0; i < appArr.size() ; i++)
        {
            comboBoxList.getItems().remove(appArr.get(i).getAppointmenttime());
            System.out.println(appArr.get(i).getAppointmenttime());
        }
    }

    public void bookAppointment() {
        if (appointmentDatePicker.getValue() == null || comboBoxList.getSelectionModel().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Booking Information");
            alert.setHeaderText(null);
            alert.setContentText("Select date and time!");
            alert.showAndWait();
        }
        else {
            String msg = pickADateViewModel.addAppointment(appointmentDatePicker.getValue().toString(), pickADateViewModel.getDoctorID(), pickADateViewModel.getUserID(), comboBoxList.getSelectionModel().getSelectedItem());

            if(msg.equals("Success")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Booking Information");
                alert.setHeaderText(null);
                alert.setContentText("You've successfully made an appointment!" + "\n"
                        + "Date: " + appointmentDatePicker.getValue().toString() + "\n"
                        + "Time: " + comboBoxList.getSelectionModel().getSelectedItem());
                alert.showAndWait();
                if(alert.getResult() == ButtonType.OK) {
                    selectDate();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Booking Information");
                alert.setHeaderText(null);
                alert.setContentText(msg);
                alert.showAndWait();
            }
        }
    }

    public void goBack() {
        viewHandler.openPatientView();
    }
}
