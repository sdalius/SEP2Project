package View.DoctorList;

import Shared.Doctor;
import View.ViewHandler;
import ViewModel.DoctorList.DoctorListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    public void init(DoctorListViewModel patientViewModel, ViewHandler viewHandler) {

    }
}
