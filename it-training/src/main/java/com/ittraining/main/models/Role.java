package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;
	private String designationRole;

	@ManyToMany
	@JoinColumn(name = "id_employe")
	@JsonIgnore
	private Employe employe;

	public Role() {
		super();
	}

	public Role(String designationRole, Employe employe) {
		super();
		this.designationRole = designationRole;
		this.employe = employe;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public String getDesignationRole() {
		return designationRole;
	}

	public void setDesignationRole(String designationRole) {
		this.designationRole = designationRole;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", designationRole=" + designationRole + ", employe=" + employe + "]";
	}

}
