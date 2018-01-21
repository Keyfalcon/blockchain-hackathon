package com.itgrids.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_notification")
public class Notification extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "farmer")
	private Farmer farmer;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

}
