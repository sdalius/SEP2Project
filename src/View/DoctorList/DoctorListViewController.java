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
    private TableColumn FNameCol;
    @FXML
    private TableColumn LNameCol;
    @FXML
    private TableColumn OfficeNoCol;
    @FXML
    private TableColumn PhoneNoCol;
    @FXML
    private TableColumn emailCol;
    private DoctorListViewModel doctorListViewModel;
    private ViewHandler viewHandler;

    public void init(DoctorListViewModel doctorListViewModel, ViewHandler viewHandler) {
        this.doctorListViewModel = doctorListViewModel;
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
