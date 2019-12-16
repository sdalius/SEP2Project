package ViewModel.EditAppointment;

import Model.BookingClientInterface;
import Shared.Appointment;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class EditAppointmentViewModel {

    private BookingClientInterface clientInterface;
    private Appointment appointment;

    public EditAppointmentViewModel(BookingClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public ArrayList<Appointment> getAppointmentsAccordingToDate(String date) {
        ArrayList<Appointment> appArr = new ArrayList<>();
        try {
            appArr = clientInterface.getAppointmentListAccordingToDate(date);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return appArr;
    }

    public void updateAppointment(String olddate, String oldappointmenttime, String newdate, String newappointmenttime) {
        try {
            clientInterface.updateAppointment(olddate, oldappointmenttime, newdate, newappointmenttime);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
    }
}
