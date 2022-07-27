package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;
	private String designationRole;
	
	public Role() {
		super();
	}
	
	public Role(String designationRole) {
		super();
		this.designationRole = designationRole;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getDesignationRole() {
		return designationRole;
	}

	public void setDesignationRole(String designationRole) {
		this.designationRole = designationRole;
	}

	@Override
	public String toString() {
		return "Roles [idRole=" + idRole + ", designationRole=" + designationRole + "]";
	}
	
}
