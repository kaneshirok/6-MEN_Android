package com.src.novel.todokeru.post;

import com.google.gson.Gson;

/**
 * Created by pdc-k-kamiya on 2017/12/03.
 */

public class UserPost {
    private String latitude;
    private String longitude;
    private int tag_id;
    private int user_id;
    private String tag_name;
    private String user_name;
    private String user_image;

    public UserPost() {
        latitude = null;
        longitude = null;
        tag_name = null;
        user_name = null;
        user_image = null;
        user_id = -1;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String toJson(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("latitude", "");
//        map.put("longitude", "");
//        map.put("tag_id", "");
//        map.put("user_id", "");
//        map.put("tag_name", "");
//        map.put("user_name", user_name);
//        map.put("user_image", user_image);
//        private String latitude;
//        private String longitude;
//        private int tag_id;
//        private int user_id;
//        private String tag_name;
//        private String user_name;
//        private String user_image;
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
