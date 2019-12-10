package Shared;

import java.io.Serializable;

public abstract class User implements Serializable {
    private int userID;
    private String usertype;
    public User(int userID, String usertype)
    {
        this.userID = userID;
        this.usertype = usertype;
    }
    public int getUserID() {
        return userID;
    }


    public String getUsertype() {
        return usertype;
    }
}
