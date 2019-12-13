package ViewModel.PickADate;

import Model.BookingClientInterface;
import Shared.Appointment;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class PickADateViewModel {

    private BookingClientInterface bookingClient;
    public PickADateViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

    public ArrayList<Appointment> getAppointmentsAccordingToDate(String date)
    {
        ArrayList<Appointment> appointmentListAccordingToDate = null;
        try {
            appointmentListAccordingToDate = bookingClient.getAppointmentListAccordingToDate(date);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return appointmentListAccordingToDate;
    }

}
