package View.Patient;

import Shared.Doctor;
import Shared.Patient;
import Shared.User;
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
    private User usr;

    public void init(PatientViewModel patientViewModel, ViewHandler viewHandler) {
        this.patientViewModel = patientViewModel;
        this.viewHandler = viewHandler;
    }

    public void openDoctorListView() {
        viewHandler.openDoctorListView (usr);
    }
    public void setUsr(Object user)
    {
        if (user instanceof Patient)
        {
            usr = (Patient) user;
            lblName.setText (((Patient) user).getFname ());
        }
        else if (user instanceof Doctor)
        {
            usr = (Doctor) user;
            lblName.setText (((Doctor) user).getFname ());
        }
    }
}
