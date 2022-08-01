package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adresses")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdresse;
	private int noAdresse;
	private String rue;
	private String codePostal;
	private String ville;

	@OneToMany
//	@JoinColumn(name = "id_session")
	@JsonIgnore
	private List<Session> sessions = new ArrayList<Session>();

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(int noAdresse, String rue, String codePostal, String ville, List<Session> sessions) {
		super();
		this.noAdresse = noAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.sessions = sessions;
	}

	public Integer getIdAdresse() {
		return idAdresse;
	}

	public int getNoAdresse() {
		return noAdresse;
	}

	public void setNoAdresse(int noAdresse) {
		this.noAdresse = noAdresse;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", noAdresse=" + noAdresse + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", sessions=" + sessions + "]";
	}

}
