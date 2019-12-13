package Server;

import Shared.Appointment;
import Shared.Doctor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ServerInterface extends Remote {
    String createAccount(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password) throws RemoteException;
    Object logIn(String username, String password) throws RemoteException;
    ArrayList<Doctor> getDoctorList() throws RemoteException;
    ArrayList<Appointment> getAppointmentsAccordingToDate(String date) throws RemoteException;
    String bookAppointment(LocalDate date, int doctorID, int patientID) throws RemoteException;
}
