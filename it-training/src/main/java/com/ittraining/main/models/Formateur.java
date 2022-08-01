package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "formateurs")
public class Formateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomFormateur;
	private String prenomFormateur;
	private String emailFormateur;
	private String passwordFormateur;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Session> sessions = new ArrayList<Session>();

	public Formateur() {
		super();
	}

	public Formateur(String nomFormateur, String prenomFormateur, String emailFormateur, String passwordFormateur,
			List<Session> sessions) {
		super();
		this.nomFormateur = nomFormateur;
		this.prenomFormateur = prenomFormateur;
		this.emailFormateur = emailFormateur;
		this.passwordFormateur = passwordFormateur;
		this.sessions = sessions;
	}

	public Integer getId() {
		return id;
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

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Formateur [idFormateur=" + id + ", nomFormateur=" + nomFormateur + ", prenomFormateur="
				+ prenomFormateur + ", emailFormateur=" + emailFormateur + ", passwordFormateur=" + passwordFormateur
				+ ", sessions=" + sessions + "]";
	}

}
