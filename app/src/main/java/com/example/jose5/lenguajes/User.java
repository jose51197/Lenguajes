package com.example.jose5.lenguajes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jose5 on 2/20/2018.
 */

public class User implements Serializable {
    String user;
    String pass;
    ArrayList<Event> events=new ArrayList<>();

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public boolean login(String password){
        if(pass.equals(password)){
            return true;
        }
        return false;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
