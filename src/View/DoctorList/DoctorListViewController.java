package View.DoctorList;

import Shared.Doctor;
import Shared.Patient;
import Shared.User;
import View.ViewHandler;
import ViewModel.DoctorList.DoctorListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private User usr;


    public void init(DoctorListViewModel doctorListViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        FNameCol.setCellValueFactory(new PropertyValueFactory<>("fname"));
        LNameCol.setCellValueFactory(new PropertyValueFactory<>("lname"));
        OfficeNoCol.setCellValueFactory(new PropertyValueFactory<>("officenr"));
        PhoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        eMailCol.setCellValueFactory (new PropertyValueFactory<>("email"));
        doctorTableView.setItems(doctorListViewModel.getDoctors());
    }

    public void onBackButton(){
        viewHandler.openPatientView(usr);
    }

    public void setUsr(Object user)
    {
        if (user instanceof Patient)
        {
            usr = (Patient) user;
        }
        else if (user instanceof Doctor)
        {
            usr = (Doctor) user;
        }
    }
    public void bookanAppointment() {
        System.out.println (doctorTableView.getSelectionModel().getSelectedItem ().getUserID ());
    }
}
