package com.keyfalcon.blockchain.model;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class MySchdulesModel {

    public enum ScheduleStatus {
        PENDING, COMPLETED
    }

    private String title;
    private String status;
    private String condition;
    private String number;
    private String icon;
    private ScheduleStatus sStatus;

    public MySchdulesModel() {
    }

    public MySchdulesModel(String title, String status, String condition, String number, String icon, ScheduleStatus sStatus) {
        this.title = title;
        this.status = status;
        this.condition = condition;
        this.number = number;
        this.icon = icon;
        this.sStatus = sStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ScheduleStatus getsStatus() {
        return sStatus;
    }

    public void setsStatus(ScheduleStatus sStatus) {
        this.sStatus = sStatus;
    }
}
