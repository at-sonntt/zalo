package com.example.mrson.menudemo;

/**
 * Created by Tuy on 6/29/2015.
 */
public class Favourit {
    private int icon;
    private String title;


    private boolean isGroupHeader = false;

    public Favourit(String title) {
        this(-1, title);
        isGroupHeader = true;
    }

    public Favourit(int icon, String title) {
        super();
        this.icon = icon;
        this.title = title;

    }

    public Favourit() {
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGroupHeader() {
        return isGroupHeader;
    }

    public void setGroupHeader(boolean isGroupHeader) {
        this.isGroupHeader = isGroupHeader;
    }
}
