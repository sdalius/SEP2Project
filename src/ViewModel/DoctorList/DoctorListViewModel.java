package ViewModel.DoctorList;

import Model.BookingClientInterface;
import Shared.Doctor;
import Shared.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;

public class DoctorListViewModel {

    private ObservableList<Doctor> doctors;
    private BookingClientInterface clientInterface;
    private Patient patient;

    public DoctorListViewModel(BookingClientInterface clientInterface) {
        this.clientInterface = clientInterface;
        doctors = FXCollections.observableArrayList();
    }

    public ObservableList<Doctor> getDoctors() {
        try {
            doctors.clear();
            doctors.addAll(clientInterface.getDoctorList());
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return doctors;
    }
    public void setPatient()
    {
        try {
            this.patient = (Patient) clientInterface.getUsr();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }
    public Patient getUser() {
        return patient;
    }


}
