package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employes")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomEmploye;
	private String prenomEmploye;
	private String passwordEmploye;
	private String emailEmploye;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_role")
	private List<Role> roles = new ArrayList<Role>();

	@JsonIgnore
	@OneToMany(mappedBy = "employe")
	private List<Formation> formations = new ArrayList<Formation>();

	public Employe() {
		super();
	}

	public Employe(String nomEmploye, String prenomEmploye, String passwordEmploye, String emailEmploye,
			List<Role> roles, List<Formation> formations) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.passwordEmploye = passwordEmploye;
		this.emailEmploye = emailEmploye;
		this.roles = roles;
		this.formations = formations;
	}

	public Integer getId() {
		return id;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getPasswordEmploye() {
		return passwordEmploye;
	}

	public void setPasswordEmploye(String passwordEmploye) {
		this.passwordEmploye = passwordEmploye;
	}

	public String getEmailEmploye() {
		return emailEmploye;
	}

	public void setEmailEmploye(String emailEmploye) {
		this.emailEmploye = emailEmploye;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", passwordEmploye=" + passwordEmploye + ", emailEmploye=" + emailEmploye + ", roles=" + roles
				+ ", formations=" + formations + "]";
	}

}
