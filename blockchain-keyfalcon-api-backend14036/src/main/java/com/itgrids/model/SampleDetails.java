package com.itgrids.model;

import java.util.List;

public class SampleDetails {

	private List<String> images;

	private Double latitude;

	private Double longitude;

	private Integer samplesInGoodCondition;

	private Integer farmerId;

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
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

	public Integer getSamplesInGoodCondition() {
		return samplesInGoodCondition;
	}

	public void setSamplesInGoodCondition(Integer samplesInGoodCondition) {
		this.samplesInGoodCondition = samplesInGoodCondition;
	}

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

}
