package View.DoctorList;

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
    private DoctorListViewModel doctorListViewModel;
    private ViewHandler viewHandler;

    public void init(DoctorListViewModel doctorListViewModel, ViewHandler viewHandler) {
        this.doctorListViewModel = doctorListViewModel;
        this.viewHandler = viewHandler;

    }
}
