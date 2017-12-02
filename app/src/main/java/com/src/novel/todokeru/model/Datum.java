
package com.src.novel.todokeru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("user_id")
    @Expose
    private float userId;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("tag_name")
    @Expose
    private String tagName;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("tag_id")
    @Expose
    private float tagId;
    @SerializedName("user_image")
    @Expose
    private String userImage;

    public float getUserId() {
        return userId;
    }

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public float getTagId() {
        return tagId;
    }

    public void setTagId(float tagId) {
        this.tagId = tagId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }


}
