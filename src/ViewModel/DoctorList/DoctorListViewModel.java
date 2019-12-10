package ViewModel.DoctorList;

import Model.BookingClientInterface;
import Shared.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;

public class DoctorListViewModel {

    private ObservableList<Doctor> doctors;
    private BookingClientInterface clientInterface;

    public DoctorListViewModel(BookingClientInterface clientInterface) {
        this.clientInterface = clientInterface;
        doctors = FXCollections.observableArrayList();
    }

    public ObservableList<Doctor> getDoctors() {
        try {
            doctors.addAll(clientInterface.getDoctorList());
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return doctors;
    }
}
