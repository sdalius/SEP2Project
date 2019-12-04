package Shared;

import java.io.Serializable;

public class User implements Serializable {
    private int userID;
    private String username;
    private String usertype;
    public User(int userID,String username, String usertype)
    {
        this.userID = userID;
        this.username = username;
        this.usertype = usertype;
    }
    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getUsertype() {
        return usertype;
    }
}
