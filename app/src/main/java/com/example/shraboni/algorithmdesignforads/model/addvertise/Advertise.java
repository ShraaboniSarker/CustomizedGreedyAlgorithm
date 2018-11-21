package com.example.shraboni.algorithmdesignforads.model.addvertise;

public class Advertise {
    private String addname;
    private String time;

    public Advertise(String addname, String time) {
        this.addname = addname;
        this.time = time;
    }

    public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
