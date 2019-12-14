package Model;

import Shared.Appointment;
import Shared.Doctor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BookingClientInterface extends Remote {
    String createAccount(String fname, String lname, String username, String address, String birthdate, String phoneNo, String eMail, String password) throws RemoteException;
    Object logIn(String username, String password) throws RemoteException;
    ArrayList<Doctor> getDoctorList() throws RemoteException;
    ArrayList<Appointment> getAppointmentListAccordingToDate(String date) throws RemoteException;
    String addAppointment(String date, int doctorID, int patientID, String appointmenttime) throws RemoteException;
    Object getUsr() throws RemoteException;
}
