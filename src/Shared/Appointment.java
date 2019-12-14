package Shared;

import java.io.Serializable;

public class Appointment implements Serializable {
    private String appointmentdate,appointmenttime,fname,lname;
    private int doctoruid,patientuid;

    public Appointment(String appointmentdate, int doctoruid, int patientuid, String appointmenttime) {
        this.appointmentdate = appointmentdate;
        this.doctoruid = doctoruid;
        this.patientuid = patientuid;
        this.appointmenttime = appointmenttime;
    }

    public String getAppointmentdate() {
        return appointmentdate;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public int getDoctoruid() {
        return doctoruid;
    }

    public int getPatientuid() {
        return patientuid;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentdate='" + appointmentdate + '\'' +
                ", appointmenttime='" + appointmenttime + '\'' +
                ", doctoruid=" + doctoruid +
                ", patientuid=" + patientuid +
                '}';
    }
}
