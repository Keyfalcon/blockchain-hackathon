package com.keyfalcon.blockchain.model;

import java.util.List;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class FarmerModel {

    /**
     * aadharNumber : 0
     * accNumber : 0
     * bankName : string
     * ifscCode : string
     * locationDetails : [{"area":0,"images":["string"],"latitude":0,"longitude":0,"soilType":"string","surveyNumber":"string","waterResource":"string"}]
     * name : string
     * phoneNumber : 0
     */

    private int aadharNumber;
    private int accNumber;
    private String bankName;
    private String ifscCode;
    private String name;
    private String phoneNumber;
    private String fcmToken;
    private List<LandModel> locationDetails;

    public int getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<LandModel> getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(List<LandModel> locationDetails) {
        this.locationDetails = locationDetails;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}
