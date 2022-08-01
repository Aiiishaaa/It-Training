package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

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
	private List<Employe> employe = new ArrayList<Employe>();

	public Role() {
		super();
	}

	public Role(String designationRole, List<Employe> employe) {
		super();
		this.designationRole = designationRole;
		this.employe = employe;
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

	public List<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", designationRole=" + designationRole + ", employe=" + employe + "]";
	}

}
