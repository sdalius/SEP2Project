package ViewModel.PickADate;

import Model.BookingClientInterface;
import Shared.Appointment;
import com.sun.security.ntlm.Server;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PickADateViewModel {

    private BookingClientInterface bookingClient;
    public PickADateViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public ArrayList<Appointment> getAppointmentsAccordingToDate(String date) {
        ArrayList<Appointment> appArr = new ArrayList<>();
        try {
            appArr = bookingClient.getAppointmentListAccordingToDate(date);
        } catch (RemoteException e) {
            e.printStackTrace ();
        }
        return appArr;
    }

    public String addAppointment(String date, int doctorID, int patientID, String appointmenttime) {
        try {
            return bookingClient.addAppointment(date, doctorID, patientID,appointmenttime);
        } catch(RemoteException e) {
           return e.getMessage();
        }
    }
}
