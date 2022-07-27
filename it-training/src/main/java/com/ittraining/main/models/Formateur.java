package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formateurs")
public class Formateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormateur;
	
	private String nomFormateur;
	private String prenomFormateur;
	private String emailFormateur;
	private String passwordFormateur;
	
	public Formateur() {
		super();
	}

	public Formateur(String nomFormateur, String prenomFormateur, String emailFormateur, String passwordFormateur) {
		super();
		this.nomFormateur = nomFormateur;
		this.prenomFormateur = prenomFormateur;
		this.emailFormateur = emailFormateur;
		this.passwordFormateur = passwordFormateur;
	}

	public Integer getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(Integer idFormateur) {
		this.idFormateur = idFormateur;
	}

	public String getNomFormateur() {
		return nomFormateur;
	}

	public void setNomFormateur(String nomFormateur) {
		this.nomFormateur = nomFormateur;
	}

	public String getPrenomFormateur() {
		return prenomFormateur;
	}

	public void setPrenomFormateur(String prenomFormateur) {
		this.prenomFormateur = prenomFormateur;
	}

	public String getEmailFormateur() {
		return emailFormateur;
	}

	public void setEmailFormateur(String emailFormateur) {
		this.emailFormateur = emailFormateur;
	}

	public String getPasswordFormateur() {
		return passwordFormateur;
	}

	public void setPasswordFormateur(String passwordFormateur) {
		this.passwordFormateur = passwordFormateur;
	}

	@Override
	public String toString() {
		return "Formateurs [idFormateur=" + idFormateur + ", nomFormateur=" + nomFormateur + ", prenomFormateur="
				+ prenomFormateur + ", emailFormateur=" + emailFormateur + ", passwordFormateur=" + passwordFormateur
				+ "]";
	}
	
	

}
