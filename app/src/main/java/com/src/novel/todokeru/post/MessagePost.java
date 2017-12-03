package com.src.novel.todokeru.post;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

/**
 * Created by pdc-k-kamiya on 2017/12/03.
 */

public class MessagePost {
    @Expose
    private float user_id;
    @Expose
    private int send_user_id;
    @Expose
    private String message;

    public MessagePost() {
        message = null;
    }

    public float getUser_id() {
        return user_id;
    }

    public void setUser_id(float user_id) {
        this.user_id = user_id;
    }

    public int getSend_user_id() {
        return send_user_id;
    }

    public void setSend_user_id(int send_user_id) {
        this.send_user_id = send_user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
