package com.itgrids.model;

import java.util.List;

public class ForestOfficer {

	private String name;

	private String password;

	private List<SampleDetails> sampleDetails;

	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SampleDetails> getSampleDetails() {
		return sampleDetails;
	}

	public void setSampleDetails(List<SampleDetails> sampleDetails) {
		this.sampleDetails = sampleDetails;
	}

}
