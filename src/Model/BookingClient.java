package Model;

import Server.ServerInterface;
import Shared.Appointment;
import Shared.Doctor;
import Shared.Patient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class BookingClient implements BookingClientInterface {
    private ServerInterface serverInterface;
    private Object usr;

    public BookingClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverInterface = (ServerInterface) registry.lookup("BookingServer");
    }

    @Override
    public String createAccount(String fname, String lname, String username, String address, String birthdate, String phoneNo, String eMail, String password) {
        System.out.println("[BookingClient] I've received a patient with a name of:" + fname);
        try {
            serverInterface.createAccount(fname, lname, username, address, birthdate, phoneNo, eMail, password);
            System.out.println("[BookingClient] Sending object to the server Interface");
            return "Success";
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Object logIn(String username, String password) {
        try {
            usr = serverInterface.logIn(username, password);
            return usr;
        } catch(RemoteException e) {
            return null;
        }
    }

    public Object getUsr() {
        return usr;
    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        ArrayList<Doctor> doctorList = new ArrayList<>();
        try {
            doctorList = serverInterface.getDoctorList();
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return doctorList;
    }

    public ArrayList<Appointment> getAppointmentListAccordingToDate(String date) {
        ArrayList<Appointment> appointmentsAccordingToDate = new ArrayList<>();
        try {
            appointmentsAccordingToDate = serverInterface.getAppointmentsAccordingToDate(date);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return appointmentsAccordingToDate;
    }

    public ArrayList<Appointment> getAppointmentListAccordingToDateAndDoctorID(String date,int doctorID) {
        ArrayList<Appointment> appointmentsAccordingToDate = new ArrayList<>();
        try {
            appointmentsAccordingToDate = serverInterface.getAppointmentsAccordingToDateAndDoctorID(date,doctorID);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return appointmentsAccordingToDate;
    }

    public String addAppointment(String date, int doctorID, int patientID, String appointmenttime) {
        try {
            serverInterface.addAppointment(date, doctorID, patientID, appointmenttime);
            return "Success";
        } catch(RemoteException e) {
            return e.getMessage();
        }
    }

    public Patient getPatientByID(int id)
    {
        try {
            return serverInterface.getPatientByID(id);
        } catch(RemoteException e) {
           return null;
        }
    }

    public String deleteAppointment(String date, String time)
    {
        try {
            serverInterface.deleteAppointment(date,time);
        } catch(RemoteException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String updateAppointment(String olddate, String oldappointmenttime, String newdate, String newappointmenttime) throws RemoteException {
        return serverInterface.updateAppointment(olddate,oldappointmenttime,newdate,newappointmenttime);
    }
}


