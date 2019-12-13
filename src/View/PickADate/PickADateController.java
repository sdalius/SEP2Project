package View.PickADate;

import Shared.Appointment;
import View.ViewHandler;
import ViewModel.PickADate.PickADateViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PickADateController {

    @FXML
    ComboBox<String> comboBoxList;
    @FXML
    Label timeLabel;
    @FXML
    Label dateLabel;
    @FXML
    DatePicker appointmentDatePicker;
    private int userID;
    private int doctorID;

    private PickADateViewModel pickADateViewModel;
    private ViewHandler viewHandler;

    public void init(PickADateViewModel pickadateviewmodel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.pickADateViewModel = pickadateviewmodel;
        appointmentDatePicker.setValue(LocalDate.now());
        comboBoxList.setPromptText("Select time");
        reupdateTimes();
        appointmentDatePicker.setOnAction(event -> {
            ArrayList<Appointment> appArr = pickadateviewmodel.getAppointmentsAccordingToDate(appointmentDatePicker.getValue().toString());
            if (appArr == null)
            {
                System.out.println("We dont have anything booked at this date");
                reupdateTimes();
                return;
            }
            else{
                removeTimeFromList(appArr);
            }
            System.out.println("Date picked:" + appointmentDatePicker.getValue().toString());
        });
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setDoctorID(int doctorID)
    {
        this.doctorID = doctorID;
    }

    public void reupdateTimes()
    {
        comboBoxList.getItems().clear();
        comboBoxList.getItems().addAll(
                "8:30:00",
                "9:00:00",
                "9:30:00",
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
    public void updateTimeLabel() {
        //timeLabel.setText("Selected time: " + comboBoxList.getSelectionModel().getSelectedItem());
    }

    public void updateDateLabel() {
        //dateLabel.setText(appointmentDatePicker.get);
        //dateLabel.setText("Selected date: " + appointmentDatePicker.getValue());
    }

    public void removeTimeFromList(ArrayList<Appointment> appArr)
    {
        for(int i = 0; i < appArr.size() ; i++)
        {
            comboBoxList.getItems().remove(appArr.get(i).getAppointmenttime());
        }
    }

    public void changeLabel() {
        timeLabel.setText("Selected time " + comboBoxList.getSelectionModel().getSelectedItem() +
                " Selected date:" + appointmentDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(comboBoxList.getSelectionModel().getSelectedIndex());
        comboBoxList.getItems().remove(0);
    }

    public void bookAppointment() {
        System.out.println("Doctor ID " + doctorID + "\n"
        + "User ID " + userID + "\n"
        +"Date: " + appointmentDatePicker.getValue() + "\n"
        + "Time: " + comboBoxList.getSelectionModel().getSelectedItem());

        pickADateViewModel.addAppointment(appointmentDatePicker.getValue().toString(),doctorID,userID,comboBoxList.getSelectionModel().getSelectedItem());
    }

    public void goBack(ActionEvent actionEvent) {
    }
}
