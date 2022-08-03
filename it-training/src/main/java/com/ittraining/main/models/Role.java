package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private RoleName designation;

	@ManyToMany
	@JoinColumn(name = "id_employe")
	private List<Employe> employes = new ArrayList<Employe>();

	public Role() {
		super();
	}

	public Role(RoleName designation, List<Employe> employes) {
		super();
		this.designation = designation;
		this.employes = employes;
	}

	public Integer getId() {
		return id;
	}

	public RoleName getDesignation() {
		return designation;
	}

	public void setDesignation(RoleName designation) {
		this.designation = designation;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", designation=" + designation + ", employes=" + employes + "]";
	}

}
