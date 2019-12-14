package ViewModel.PickADate;

import Model.BookingClientInterface;
import Shared.Appointment;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class PickADateViewModel {

    private BookingClientInterface bookingClient;
    private int userID;
    private int doctorID;

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

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getUserID() {
        return userID;
    }

    public int getDoctorID() {
        return doctorID;
    }
}
