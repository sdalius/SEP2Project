package ViewModel.AppointmentList;

import Model.BookingClientInterface;
import Shared.Appointment;
import Shared.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class AppointmentListViewModel {
    private BookingClientInterface bookingClient;
    private ObservableList<Appointment> appointments;

    public AppointmentListViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
        appointments = FXCollections.observableArrayList();
    }

    public ObservableList<Appointment> getAppointments(String date) throws RemoteException {
        appointments.clear();
        try {
            appointments.addAll(bookingClient.getAppointmentListAccordingToDate(date));
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
