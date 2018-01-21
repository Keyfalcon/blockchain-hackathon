package com.itgrids.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@Entity
@Table(name = "tbl_user")
@JsonSerialize(include = Inclusion.NON_NULL)
public class User extends BaseEntity implements Comparable<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_user_tbl_roles")
	private Role roles;

	private String password;

	private String fcmToken;

	private String blockTokenKey;

	private String mobile;

	private Integer farmerId;

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBlockTokenKey() {
		return blockTokenKey;
	}

	public void setBlockTokenKey(String blockTokenKey) {
		this.blockTokenKey = blockTokenKey;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
