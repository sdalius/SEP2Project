package View.AppointmentList;

import Shared.Appointment;
import View.ViewHandler;
import ViewModel.AppointmentList.AppointmentListViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
        appointmentTableView.setPlaceholder(new Label("Select date first!"));
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
            System.out.println(appointmentTableView.getItems().get(0).getAppointmenttime());
        } catch(NullPointerException e) {
            appointmentTableView.setPlaceholder(new Label("No appointments this day"));
        }
    }

    public void cancelAppointment() {
        try{
            String time = appointmentTableView.getSelectionModel().getSelectedItem().getAppointmenttime();
            String date = appointmentTableView.getSelectionModel().getSelectedItem().getAppointmentdate();
            appointmentTableView.getItems().remove(appointmentTableView.getSelectionModel().getSelectedItem());
            appointmentListViewModel.deleteAppointment(date,time);
            System.out.println("Appointment was canceled and deleted.");
        }
        catch(NullPointerException e)
        {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle ("Error");
            alert.setHeaderText (null);
            alert.setContentText ("Select which appointment you want to cancel!");
            alert.showAndWait ();
        }
    }

    public void changeAppointment() {
        try {
            String time = appointmentTableView.getSelectionModel().getSelectedItem().getAppointmenttime();
            String date = appointmentTableView.getSelectionModel().getSelectedItem().getAppointmentdate();
            int doctoruid = appointmentTableView.getSelectionModel().getSelectedItem().getDoctoruid();
            int patientuid = appointmentTableView.getSelectionModel().getSelectedItem().getPatientuid();
            viewHandler.openEditAppointmentView(new Appointment(date, doctoruid, patientuid, time));
        }
        catch(NullPointerException e)
        {
            Alert alert = new Alert (Alert.AlertType.ERROR);
            alert.setTitle ("Error");
            alert.setHeaderText (null);
            alert.setContentText ("Select date!");
            alert.showAndWait ();
        }
    }
}