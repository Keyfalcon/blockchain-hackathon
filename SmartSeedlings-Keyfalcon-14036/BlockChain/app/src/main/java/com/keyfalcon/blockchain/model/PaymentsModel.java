package com.keyfalcon.blockchain.model;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class PaymentsModel {

    private String title;
    private String message;
    private String time;
    private String transactionId;

    public PaymentsModel(String title, String message, String time, String transactionId) {
        this.title = title;
        this.message = message;
        this.time = time;
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
