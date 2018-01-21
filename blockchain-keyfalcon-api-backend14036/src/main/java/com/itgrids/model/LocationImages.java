package com.itgrids.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_location_images")
public class LocationImages extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String image;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "locationDetails")
	private LocationDetails locationDetails;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocationDetails getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(LocationDetails locationDetails) {
		this.locationDetails = locationDetails;
	}

}
