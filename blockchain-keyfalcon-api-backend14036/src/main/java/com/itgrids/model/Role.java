package com.itgrids.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@Entity
@Table(name = "tbl_role")
@JsonSerialize(include = Inclusion.NON_NULL)
public class Role extends BaseEntity implements Comparable<Role> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roleName;

	private String farmerId;

	public String getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int compareTo(Role o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
