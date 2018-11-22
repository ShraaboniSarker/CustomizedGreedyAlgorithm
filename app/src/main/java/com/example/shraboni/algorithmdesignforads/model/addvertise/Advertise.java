package com.example.shraboni.algorithmdesignforads.model.addvertise;

import java.util.ArrayList;

public class Advertise {
    private String addname;
    private Integer time;

    public Advertise(String addname, Integer time) {
        this.addname = addname;
        this.time = time;
    }

    public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Advertise{" +
                "addname='" + addname + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
