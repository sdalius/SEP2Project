package Server;

import Shared.Appointment;
import Shared.Doctor;
import Shared.Patient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote {
    String createAccount(String fname, String lname, String username, String address,String birthdate, String phoneNo, String eMail,String password) throws RemoteException;
    Object logIn(String username, String password) throws RemoteException;
    ArrayList<Doctor> getDoctorList() throws RemoteException;
    ArrayList<Appointment> getAppointmentsAccordingToDate(String date) throws RemoteException;
    ArrayList<Appointment> getAppointmentsAccordingToDateAndDoctorID(String date,int doctorID) throws RemoteException;
    String addAppointment(String date, int doctorID, int patientID, String appointmenttime) throws RemoteException;
    Patient getPatientByID(int id) throws RemoteException;
    void deleteAppointment(String date, String time) throws RemoteException;
    String updateAppointment(String olddate, String oldappointmenttime ,String newdate, String newappointmenttime) throws RemoteException;
}
