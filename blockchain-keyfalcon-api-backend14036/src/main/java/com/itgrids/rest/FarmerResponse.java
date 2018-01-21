package com.itgrids.rest;

import java.util.List;

public class FarmerResponse {

	private Integer id;

	private String name;

	private String surveyNumber;

	private Double area;

	private String waterResource;

	private String soilType;

	private Double latitude;

	private Double longitude;

	private String aadharNumber;

	private List<String> images;

	public FarmerResponse() {
		super();
	}

	public FarmerResponse(Integer id, String name, String surveyNumber, Double area, String waterResource,
			String soilType, Double latitude, Double longitude, String aadharNumber, List<String> images) {
		super();
		this.id = id;
		this.name = name;
		this.surveyNumber = surveyNumber;
		this.area = area;
		this.waterResource = waterResource;
		this.soilType = soilType;
		this.latitude = latitude;
		this.longitude = longitude;
		this.aadharNumber = aadharNumber;
		this.images = images;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurveyNumber() {
		return surveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getWaterResource() {
		return waterResource;
	}

	public void setWaterResource(String waterResource) {
		this.waterResource = waterResource;
	}

	public String getSoilType() {
		return soilType;
	}

	public void setSoilType(String soilType) {
		this.soilType = soilType;
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

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

}
