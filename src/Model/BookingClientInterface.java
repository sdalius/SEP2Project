package Model;

import Shared.Appointment;
import Shared.Doctor;
import Shared.Patient;

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
    ArrayList<Appointment> getAppointmentListAccordingToDateAndDoctorID(String date,int doctorID) throws RemoteException;
    Patient getPatientByID(int id) throws RemoteException;
    String deleteAppointment(String date, String time) throws RemoteException;
    String updateAppointment(String olddate, String oldappointmenttime ,String newdate, String newappointmenttime) throws RemoteException;
}
