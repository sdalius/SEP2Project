package ViewModel.AppointmentList;

import Model.BookingClientInterface;
import Shared.Appointment;
import Shared.Doctor;
import Shared.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;

public class AppointmentListViewModel {
    private BookingClientInterface bookingClient;
    private ObservableList<Appointment> appointments;
    private Doctor doctor;

    public AppointmentListViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
        appointments = FXCollections.observableArrayList();
    }

    public ObservableList<Appointment> getAppointments(String date,int doctorID) {
        appointments.clear();
        try {

            appointments.addAll(bookingClient.getAppointmentListAccordingToDateAndDoctorID(date,doctorID));
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public void setDoctor()
    {
        try {
            this.doctor = (Doctor) bookingClient.getUsr();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void deleteAppointment(String date,String time)
    {
        try {
            bookingClient.deleteAppointment(date,time);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatientByID(int id)
    {
        try {
            return bookingClient.getPatientByID(id);
        } catch(RemoteException e) {
            return null;
        }
    }
}
