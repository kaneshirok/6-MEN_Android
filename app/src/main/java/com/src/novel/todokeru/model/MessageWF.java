package com.src.novel.todokeru.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kazuki on 2017/12/03.
 */

public class MessageWF {

    @SerializedName("user_id")
    @Expose
    private float userId;
    @SerializedName("send_user_id")
    @Expose
    private float sendUserId;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("send_message_count")
    @Expose
    private float sendMessageCount;

    public float getUserId() {
        return userId;
    }

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public float getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(float sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getSendMessageCount() {
        return sendMessageCount;
    }

    public void setSendMessageCount(float sendMessageCount) {
        this.sendMessageCount = sendMessageCount;
    }
}
