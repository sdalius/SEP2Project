package ViewModel.DoctorList;

import Model.BookingClientInterface;
import Shared.Doctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DoctorListViewModel {

    private ObservableList<Doctor> doctors;
    private BookingClientInterface clientInterface;


    public DoctorListViewModel(BookingClientInterface clientInterface) {
        this.clientInterface = clientInterface;
        doctors = FXCollections.observableArrayList();
    }

    public ObservableList<Doctor> getDoctors() {
        doctors.addAll(clientInterface.getDoctorList());
        return doctors;
    }
}
