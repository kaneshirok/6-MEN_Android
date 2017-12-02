package com.src.novel.todokeru.post;

import com.google.gson.Gson;

/**
 * Created by pdc-k-kamiya on 2017/12/03.
 */

public class MessagePost {
    private int user_id;
    private int send_user_id;
    private String message;

    public MessagePost() {
        message = null;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
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
