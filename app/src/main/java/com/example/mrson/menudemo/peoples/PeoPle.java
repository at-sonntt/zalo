package com.example.mrson.menudemo.peoples;

/**
 * Created by son on 5/22/2015.
 */
public class PeoPle {
    String name;
    String message;

    int a_var;
    boolean follow;

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getA_var() {
        return a_var;
    }

    public void setA_var(int a_var) {
        this.a_var = a_var;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
