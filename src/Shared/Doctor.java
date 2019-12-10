package Shared;

import java.io.Serializable;

public class Doctor extends User implements Serializable {
    private String fname,lname,phoneNo,email;
    private int officenr;
    public Doctor(int doctorid, String fname, String lname, String phoneNo, String email, int officenr)
    {
        super (doctorid,"Doctor");
        this.fname = fname;
        this.lname = lname;
        this.phoneNo = phoneNo;
        this.email = email;
        this.officenr = officenr;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public int getOfficenr() {
        return officenr;
    }
}
