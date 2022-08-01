package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String designationRole;

	@ManyToMany
	@JsonIgnore
	private List<Employe> employes = new ArrayList<Employe>();

	public Role() {
		super();
	}

	public Role(Integer id, String designationRole, List<Employe> employes) {
		super();
		this.id = id;
		this.designationRole = designationRole;
		this.employes = employes;
	}

	public Integer getId() {
		return id;
	}

	public String getDesignationRole() {
		return designationRole;
	}

	public void setDesignationRole(String designationRole) {
		this.designationRole = designationRole;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", designationRole=" + designationRole + ", employes=" + employes + "]";
	}

}
