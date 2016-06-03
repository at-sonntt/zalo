package com.example.mrson.menudemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mrson on 18/06/2015.
 */

public class Myfeed implements Parcelable {
    String id;
    String name;
    String image;
    String status;
    String profilePic;
    String timeStamp;
    String url;
    boolean cmt;
    boolean isLike;
    int total_like;
    String test;

    public Myfeed(Parcel str) {
        readFromParcel(str);
    }

    public Myfeed() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getImage() {
        return image;

    }

    public String setImage(String image) {
        this.image = image;
        return image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setIsLike(boolean isLike) {
        this.isLike = isLike;
    }

    public int getTotal_like() {
        return total_like;
    }

    public void setTotal_like(int total_like) {
        this.total_like = total_like;
    }

    public boolean isCmt() {
        return cmt;
    }

    public void setCmt(boolean cmt) {
        this.cmt = cmt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(status);
        dest.writeString(profilePic);
        dest.writeByte((byte) (isLike ? 1 : 0));
        //     dest.writeInt(total_like);


    }

    private void readFromParcel(Parcel Str) {
        name = Str.readString();
        image = Str.readString();
        status = Str.readString();
        profilePic = Str.readString();
        isLike = Str.readByte() != 0;
        // total_like=Str.readInt();

    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Myfeed createFromParcel(Parcel Str) {
            return new Myfeed(Str);
        }

        public Myfeed[] newArray(int size) {
            return new Myfeed[size];
        }
    };

}
