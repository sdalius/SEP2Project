package View.DoctorList;

import Shared.Doctor;
import Shared.Patient;
import View.ViewHandler;
import ViewModel.DoctorList.DoctorListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DoctorListViewController {

    @FXML
    private TableView<Doctor> doctorTableView;
    @FXML
    private TableColumn<Doctor, String> FNameCol;
    @FXML
    private TableColumn<Doctor, String> LNameCol;
    @FXML
    private TableColumn<Doctor, String> OfficeNoCol;
    @FXML
    private TableColumn<Doctor, String> PhoneNoCol;
    @FXML
    private TableColumn<Doctor, String> eMailCol;

    private ViewHandler viewHandler;
    private Patient usr;
    private DoctorListViewModel doctorListViewModel;


    public void init(DoctorListViewModel doctorListViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.doctorListViewModel = doctorListViewModel;
        FNameCol.setCellValueFactory(new PropertyValueFactory<>("fname"));
        LNameCol.setCellValueFactory(new PropertyValueFactory<>("lname"));
        OfficeNoCol.setCellValueFactory(new PropertyValueFactory<>("officenr"));
        PhoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        eMailCol.setCellValueFactory (new PropertyValueFactory<>("email"));
        doctorTableView.setItems(doctorListViewModel.getDoctors());
        this.usr = doctorListViewModel.getUser();
    }

    public void onBackButton(){
        viewHandler.openPatientView();
    }

    public void bookanAppointment() {
        if(doctorTableView.getSelectionModel().getSelectedItem() == null)
        {
            Alert alert = new Alert( Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Select a doctor from the list!");
            alert.showAndWait();
        }
        else {
            viewHandler.openPickADateView((usr.getUserID()), doctorTableView.getSelectionModel().getSelectedItem().getUserID());
        }
    }
}
