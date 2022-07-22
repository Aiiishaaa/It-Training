package com.ittraining.main.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employes")
public class Employes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmploye;
	
	private String nomEmploye;
	private String prenomEmploye;
	private String passwordEmploye;
	private String emailEmploye;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_role", referencedColumnName = "id_role")
	private Integer idRole;

	public Employes(String nomEmploye, String prenomEmploye, String passwordEmploye, String emailEmploye,
			Integer idRole) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.passwordEmploye = passwordEmploye;
		this.emailEmploye = emailEmploye;
		this.idRole = idRole;
	}

	public Employes() {
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

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	@Override
	public String toString() {
		return "Employes [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", passwordEmploye=" + passwordEmploye + ", emailEmploye=" + emailEmploye + ", idRole=" + idRole
				+ "]";
	}
	
	

}
