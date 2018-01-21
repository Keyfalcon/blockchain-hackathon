package com.itgrids.service;

public class LocationDetailResponse {

	private String surveyNumber;

	private String soilType;

	private Double area;

	private Double latitude;

	private Double longitude;

	private String waterResource;

	public LocationDetailResponse() {
		super();
	}

	public LocationDetailResponse(String surveyNumber, String soilType, Double area, Double latitude, Double longitude,
			String waterResource) {
		super();
		this.surveyNumber = surveyNumber;
		this.soilType = soilType;
		this.area = area;
		this.latitude = latitude;
		this.longitude = longitude;
		this.waterResource = waterResource;
	}

	public String getSurveyNumber() {
		return surveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	public String getSoilType() {
		return soilType;
	}

	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getWaterResource() {
		return waterResource;
	}

	public void setWaterResource(String waterResource) {
		this.waterResource = waterResource;
	}

}
