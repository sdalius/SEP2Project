package View.AppointmentList;

import Shared.Appointment;
import Shared.Patient;
import View.ViewHandler;
import ViewModel.AppointmentList.AppointmentListViewModel;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;

public class AppointmentListViewController {

    @FXML
    private Button btnCancelAppointment;
    @FXML
    private DatePicker appDatePicker;
    @FXML
    private TableView<Appointment> appointmentTableView;
    @FXML
    private TableColumn<Appointment, String> dateCol;
    @FXML
    private TableColumn<Appointment, String> patientfirstnameCol ;
    @FXML
    private TableColumn<Appointment, String> patientlastnameCol;
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
        appointmentListViewModel.setDoctor();
        dateCol.setCellValueFactory(new PropertyValueFactory<>("appointmentdate"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("appointmenttime"));
        patientfirstnameCol.setCellValueFactory(patientuid -> new SimpleStringProperty(appointmentListViewModel.getPatientByID(patientuid.getValue().getPatientuid()).getFname()));
        patientlastnameCol.setCellValueFactory(patientuid -> new SimpleStringProperty(appointmentListViewModel.getPatientByID(patientuid.getValue().getPatientuid()).getLname()));
        try {
            appointmentTableView.setItems(appointmentListViewModel.getAppointments(appDatePicker.getValue().toString(),appointmentListViewModel.getDoctor().getUserID()));
        } catch(NullPointerException e) {
                System.out.println("No one is booked that day :)");
        }
    }

    public void cancelAppointment() {
        String time = appointmentTableView.getSelectionModel().getSelectedItem().getAppointmenttime();
        String date = appointmentTableView.getSelectionModel().getSelectedItem().getAppointmentdate();
        appointmentTableView.getItems().remove(appointmentTableView.getSelectionModel().getSelectedItem());
        appointmentListViewModel.deleteAppointment(date,time);
        System.out.println("Appointment was canceled and deleted.");
    }
}