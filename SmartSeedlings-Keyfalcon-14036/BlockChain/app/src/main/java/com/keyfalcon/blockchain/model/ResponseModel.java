package com.keyfalcon.blockchain.model;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class ResponseModel {

    /**
     * code : 0
     * message : string
     *
     */

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
