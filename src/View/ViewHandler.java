package View;

import Shared.Appointment;
import View.AppointmentList.AppointmentListViewController;
import View.CreateAccount.CreateAccountController;
import View.Doctor.DoctorViewController;
import View.DoctorList.DoctorListViewController;
import View.EditAppointment.EditAppointmentViewController;
import View.Login.LoginController;
import View.Patient.PatientViewController;
import View.PickADate.PickADateController;
import ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory vmf;
    private Stage mainStage;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        this.vmf = vmf;
        mainStage = stage;
    }
    public void start() {
        openLoginView();
    }

    public void openLoginView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("login/loginView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginController controller = loader.getController();
        controller.init(vmf.getLoginViewModel (), this);
        mainStage.setTitle("Login View");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openCreateAccountView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("CreateAccount/CreateAccount.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateAccountController controller = loader.getController();
        controller.init(vmf.getCreateAccountViewModel (), this);
        mainStage.setTitle("Login View");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openDoctorListView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DoctorList/DoctorListView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DoctorListViewController controller = loader.getController();
        vmf.getDoctorListViewModel().setPatient();
        controller.init(vmf.getDoctorListViewModel (), this);
        mainStage.setTitle("Doctor list");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openPatientView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Patient/PatientView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PatientViewController controller = loader.getController();
        vmf.getPatientViewModel().setPatient();
        controller.init(vmf.getPatientViewModel (), this);
        mainStage.setTitle("Patient View");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openPickADateView(int userID,int DoctorID) {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("PickADate/PickADateView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PickADateController controller = loader.getController();
        controller.init(vmf.getPickADateViewModel (), this);
        vmf.getPickADateViewModel().setUserID(userID);
        vmf.getPickADateViewModel().setDoctorID(DoctorID);
        mainStage.setTitle("Booking Options");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void openDoctorView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Doctor/DoctorView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DoctorViewController controller = loader.getController();
        controller.init(vmf.getDoctorViewModel (), this);
        mainStage.setTitle("Appointments");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openAppointmentListView() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("AppointmentList/AppointmentListView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppointmentListViewController controller = loader.getController();
        controller.init(vmf.getAppointmentListViewModel (), this);
        mainStage.setTitle("Appointment List");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void openEditAppointmentView(Appointment appointment) {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("EditAppointment/EditAppointmentView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EditAppointmentViewController controller = loader.getController();
        vmf.getEditAppointmentViewModel().setAppointment(appointment);
        controller.init(vmf.getEditAppointmentViewModel (), this);
        mainStage.setTitle("Edit Appointment");

        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
