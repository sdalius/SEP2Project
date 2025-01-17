package View.EditAppointment;

import Shared.Appointment;
import Shared.Doctor;
import Shared.Patient;
import View.ViewHandler;
import ViewModel.EditAppointment.EditAppointmentViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EditAppointmentViewController {

    @FXML
    private DatePicker doctorAppointmentDatePicker;
    @FXML
    private ComboBox timeComboBox;
    private ViewHandler viewHandler;
    private EditAppointmentViewModel editAppointmentViewModel;
    private LocalDate localDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void init(EditAppointmentViewModel editAppointmentViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.editAppointmentViewModel = editAppointmentViewModel;
        localDate = LocalDate.parse(editAppointmentViewModel.getAppointment().getAppointmentdate(), formatter);
        doctorAppointmentDatePicker.setValue(localDate);
        timeComboBox.getSelectionModel().select(editAppointmentViewModel.getAppointment().getAppointmenttime());
        selectDate();
    }

    public void selectDate()
    {
        ArrayList<Appointment> appArr = editAppointmentViewModel.getAppointmentsAccordingToDate(doctorAppointmentDatePicker.getValue().toString());
        if (appArr == null)
        {
            System.out.println("We dont have any appointments at this date");
            reupdateTimes();
        }
        else{
            removeTimeFromList(appArr);
        }
        System.out.println("Date picked:" + doctorAppointmentDatePicker.getValue().toString());
    }

    public void removeTimeFromList(ArrayList<Appointment> appArr)
    {
        reupdateTimes();
        for(int i = 0; i < appArr.size() ; i++)
        {
            if (editAppointmentViewModel.getAppointment().getAppointmenttime().equals(appArr.get(i).getAppointmenttime()) )
            {
                break;
            }
            else {
                timeComboBox.getItems().remove(appArr.get(i).getAppointmenttime());
                System.out.println(appArr.get(i).getAppointmenttime());
            }
        }
    }

    public void reupdateTimes()
    {
        timeComboBox.getItems().clear();
        timeComboBox.getItems().addAll(
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

    public void onBackButton(){
        viewHandler.openAppointmentListView();
    }

    public void changeAppointment() {
        System.out.println("Calling a method: Update Appointment");
        try{
            editAppointmentViewModel.updateAppointment(editAppointmentViewModel.getAppointment().getAppointmentdate(),editAppointmentViewModel.getAppointment().getAppointmenttime(),doctorAppointmentDatePicker.getValue().toString(),timeComboBox.getSelectionModel().getSelectedItem().toString());
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle ("Change Appointment");
            alert.setHeaderText (null);
            alert.setContentText ("Successfully changed appointment time");
            alert.showAndWait ();
            if (alert.getResult () == ButtonType.OK || alert.getResult() == ButtonType.CANCEL) {
                viewHandler.openAppointmentListView();
            }
        }
        catch (Exception e)
        {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle ("Error");
            alert.setHeaderText (null);
            alert.setContentText (e.getMessage());
            alert.showAndWait ();
        }
    }
}
