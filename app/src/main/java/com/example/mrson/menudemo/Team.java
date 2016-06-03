package com.example.mrson.menudemo;

import java.util.ArrayList;

/**
 * Created by Tuy on 7/2/2015.
 */
public class Team {


    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<Integer> getLogo() {
        return logo;
    }

    public void setLogo(ArrayList<Integer> logo) {
        this.logo = logo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    int type;
    ArrayList<String> name;
    ArrayList<Integer> logo;


}
