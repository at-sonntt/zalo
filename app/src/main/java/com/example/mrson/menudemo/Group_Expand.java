package com.example.mrson.menudemo;

import java.util.ArrayList;

/**
 * Created by Tuy on 6/29/2015.
 */
public class Group_Expand {
    private int icon;
    private String title;


    private boolean isGroupHeader = false;

    public Group_Expand(String title) {
        this(-1, title);
        isGroupHeader = true;
    }

    public Group_Expand(int icon, String title) {
        super();
        this.icon = icon;
        this.title = title;

    }

    public Group_Expand() {
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
