package com.example.mrson.menudemo;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tuy on 7/14/2015.
 */
public class ImageOnCache implements Parcelable {

    private int id;
    private String path;
    private boolean isSelected;
    private Bitmap bitmap;
    private String stringBase64;
    private boolean isFavorite;

    public ImageOnCache() {

    }

    public ImageOnCache(String path, Bitmap bitmap, boolean isSelected, boolean isFavorite) {
        this.bitmap = bitmap;
        this.path = path;
        this.isSelected = isSelected;
        this.isFavorite = isFavorite;
    }

    public ImageOnCache(Parcel in) {
        id = in.readInt();
        path = in.readString();
        isSelected = (in.readByte() != 0);
        bitmap = in.readParcelable(Bitmap.class.getClassLoader());
        stringBase64 = in.readString();
        isFavorite = (in.readByte() != 0);
    }

    public static final Creator<ImageOnCache> CREATOR = new Creator<ImageOnCache>() {

        @Override
        public ImageOnCache[] newArray(int size) {
            return new ImageOnCache[size];
        }

        @Override
        public ImageOnCache createFromParcel(Parcel source) {
            return new ImageOnCache(source);
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(path);
        dest.writeByte((byte) (isSelected ? 1 : 0));
        dest.writeParcelable(bitmap, flags);
        dest.writeString(stringBase64);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getStringBase64() {
        return stringBase64;
    }

    public void setStringBase64(String stringBase64) {
        this.stringBase64 = stringBase64;
    }

}
