package View.AppointmentList;

import Shared.Appointment;
import View.ViewHandler;
import ViewModel.AppointmentList.AppointmentListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;

public class AppointmentListViewController {

    @FXML
    private DatePicker appDatePicker;
    @FXML
    private TableView<Appointment> appointmentTableView;
    @FXML
    private TableColumn<Appointment, String> dateCol;
    @FXML
    private TableColumn<Appointment, String> patientuidCol;
    @FXML
    private TableColumn<Appointment, String> doctoruidCol;
    @FXML
    private TableColumn<Appointment, String> timeCol;

    private ViewHandler viewHandler;
    private AppointmentListViewModel appointmentListViewModel;


    public void init(AppointmentListViewModel appointmentListViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.appointmentListViewModel = appointmentListViewModel;
    }
    

    public void onBackButton() {
        viewHandler.openDoctorView();
    }

    public void dateselected() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("appointmentdate"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("appointmenttime"));
        patientuidCol.setCellValueFactory(new PropertyValueFactory<>("patientuid"));
        doctoruidCol.setCellValueFactory(new PropertyValueFactory<>("doctoruid"));
        try {
            appointmentTableView.setItems(appointmentListViewModel.getAppointments(appDatePicker.getValue().toString()));
        } catch(RemoteException | NullPointerException e) {
            if (e instanceof NullPointerException)
            {
                System.out.println("No one is booked that day :)");
            }
            else{
                e.printStackTrace();
            }
        }
    }
}