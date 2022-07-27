package com.ittraining.main.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employes")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmploye;

	private String nomEmploye;
	private String prenomEmploye;
	private String passwordEmploye;
	private String emailEmploye;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role", referencedColumnName = "id_role")
	private List<Role> roles;

	public Employe(String nomEmploye, String prenomEmploye, String passwordEmploye, String emailEmploye,
			List<Role> roles) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.passwordEmploye = passwordEmploye;
		this.emailEmploye = emailEmploye;
		this.roles = roles;
	}

	public Employe() {
		super();
	}

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
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

	@Override
	public String toString() {
		return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", passwordEmploye=" + passwordEmploye + ", emailEmploye=" + emailEmploye + ", roles=" + roles + "]";
	}

}
