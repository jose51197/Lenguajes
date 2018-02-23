package com.example.jose5.lenguajes;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jose5 on 2/20/2018.
 */

public class Event implements Serializable {
    Date date;
    String location;
    String name;

    public Event(Date date, String location, String name) {
        this.date = date;
        this.location = location;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String consult(){
        return location + " - "+date.toString();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
