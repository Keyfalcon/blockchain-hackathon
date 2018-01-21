package com.keyfalcon.blockchain.model;

/**
 * Created by Shylesh on 20-Jan-18.
 */

public class LandSurveyModel {

    public enum SurveyStatus {
        IN_PROGRESS, UPCOMING, DECLINED, SUCCESS
    }

    private String title;
    private String status;
    private String time;
    private SurveyStatus sStatus;

    public LandSurveyModel() {
    }

    public LandSurveyModel(String title, String status, String time, SurveyStatus sStutus) {
        this.title = title;
        this.status = status;
        this.time = time;
        this.sStatus = sStutus;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SurveyStatus getsStatus() {
        return sStatus;
    }

    public void setsStatus(SurveyStatus sStatus) {
        this.sStatus = sStatus;
    }
}
