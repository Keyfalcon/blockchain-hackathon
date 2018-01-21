package com.keyfalcon.blockchain.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import static com.keyfalcon.blockchain.model.LandModel.LAND_TABLE_NAME;

/**
 * Created by Shylesh on 20-Jan-18.
 */

@DatabaseTable(tableName = LAND_TABLE_NAME)
public class LandModel {

    public static final String LAND_TABLE_NAME = "LAND_TABLE";
    private final String LAND_ID = "land_id";
    private final String LAND_SURVEY_NO = "land_survey_no";
    private final String LAND_LATITUDE = "land_latitude";
    private final String LAND_LONGITUDE = "land_longitude";
    private final String LAND_AREA = "land_area";
    private final String LAND_SOURCE_OF_WATER = "land_source_of_water";
    private final String LAND_PATHS = "land_paths";
    private final String LAND_TYPE_OF_SOIL = "type_of_soil";
    private final String LAND_STATUS = "status";

    @DatabaseField(generatedId = true,columnName = LAND_ID)
    private long id;
    @DatabaseField(columnName = LAND_SURVEY_NO)
    private String surveyNumber;
    @DatabaseField(columnName = LAND_LATITUDE)
    private double latitude;
    @DatabaseField(columnName = LAND_LONGITUDE)
    private double longitude;
    @DatabaseField(columnName = LAND_AREA)
    private String area;
    @DatabaseField(columnName = LAND_SOURCE_OF_WATER)
    private String waterResource;
    @DatabaseField(dataType = DataType.SERIALIZABLE,columnName = LAND_PATHS)
    private String[] images;
    @DatabaseField(columnName = LAND_TYPE_OF_SOIL)
    private String soilType;
    @DatabaseField(columnName = LAND_STATUS)
    private String status;

    public LandModel() {
    }

    public LandModel(String mSurveyNo, double latitude, double longitude, String area, String sourceOfWater, String[] paths, String typeOfSoil,String status) {
        this.surveyNumber = mSurveyNo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.area = area;
        this.waterResource = sourceOfWater;
        this.images = paths;
        this.soilType = typeOfSoil;
        this.status = status;
    }

    public String getmSurveyNo() {
        return surveyNumber;
    }

    public void setmSurveyNo(String mSurveyNo) {
        this.surveyNumber = mSurveyNo;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSourceOfWater() {
        return waterResource;
    }

    public void setSourceOfWater(String sourceOfWater) {
        this.waterResource = sourceOfWater;
    }

    public String[] getPath() {
        return images;
    }

    public void setPath(String[] paths) {
        this.images = paths;
    }

    public String getTypeOfSoil() {
        return soilType;
    }

    public void setTypeOfSoil(String typeOfSoil) {
        this.soilType = typeOfSoil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
