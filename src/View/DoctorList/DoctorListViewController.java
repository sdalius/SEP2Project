package View.DoctorList;

import Shared.Doctor;
import View.ViewHandler;
import ViewModel.DoctorList.DoctorListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;

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
    private TableColumn<Doctor, String> emailCol;
    private ViewHandler viewHandler;

    public void init(DoctorListViewModel doctorListViewModel, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        FNameCol.setCellValueFactory(new PropertyValueFactory<>("fname"));
        LNameCol.setCellValueFactory(new PropertyValueFactory<>("lname"));
        OfficeNoCol.setCellValueFactory(new PropertyValueFactory<>("officenr"));
        PhoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("eMail"));
        try {
            doctorTableView.setItems(doctorListViewModel.getDoctors());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void onBackButton(){
        viewHandler.openPatientView();
    }
}
