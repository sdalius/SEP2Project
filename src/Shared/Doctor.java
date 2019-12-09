package Shared;

import java.io.Serializable;

public class Doctor implements Serializable {
    private String fname, lname,phoneNo,eMail,officenr;
    private int doctorid;

    public Doctor(int doctorid,String fname, String lname, String phoneNo, String eMail, String officenr)
    {
        this.doctorid = doctorid;
        this.fname = fname;
        this.lname = lname;
        this.phoneNo = phoneNo;
        this.eMail = eMail;
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

    public String geteMail() {
        return eMail;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public String getOfficenr() {
        return officenr;
    }
}
