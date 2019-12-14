package View.Patient;

import View.ViewHandler;
import ViewModel.PatientView.PatientViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PatientViewController {

    @FXML
    Button btnDoctors;
    @FXML
    Button btnPrescription;
    @FXML
    Button btnAppointment;
    @FXML
    Label lblName;

    private PatientViewModel patientViewModel;
    private ViewHandler viewHandler;

    public void init(PatientViewModel patientViewModel, ViewHandler viewHandler) {
        this.patientViewModel = patientViewModel;
        this.viewHandler = viewHandler;
        lblName.setText(patientViewModel.getUser().getFname());
    }

    public void openDoctorListView() {
        viewHandler.openDoctorListView ();
    }
}
