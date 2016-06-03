package com.example.mrson.menudemo;

/**
 * Created by Tuy on 6/29/2015.
 */
public class Child_Expand {
    public String getId() {
        return id;
    }

    public Child_Expand() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String id;
    int image;

    public Child_Expand(String id, int image) {
        this.id = id;
        this.image = image;
    }
}
