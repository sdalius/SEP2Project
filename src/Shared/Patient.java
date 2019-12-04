package Shared;

import java.io.Serializable;

public class Patient implements Serializable {
    private String fname, lname, cpr, address, birthdate, phoneNo, email, password;

    public Patient(String fname, String lname, String cpr, String address, String birthdate, String phoneNo, String email, String password)
    {
        this.fname = fname;
        this.lname = lname;
        this.cpr = cpr;
        this.address = address;
        this.birthdate = birthdate;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getCpr() {
        return cpr;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
