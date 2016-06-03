package com.example.mrson.menudemo.model;


public class NavDrawerItem {
    private boolean showNotify;
    private String title;

    public int getIc_menu_string() {
        return ic_menu_string;
    }

    public void setIc_menu_string(int ic_menu_string) {
        this.ic_menu_string = ic_menu_string;
    }

    private int ic_menu_string;


    public NavDrawerItem() {

    }

    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
