package com.ittraining.main.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inscription")
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInscription;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_client", referencedColumnName = "id_client")
	private Integer idClient;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_session", referencedColumnName = "id_session")
	private Integer idSession;

	public Inscription(Integer idInscription, Integer idClient, Integer idSession) {
		super();
		this.idClient = idClient;
		this.idSession = idSession;
	}

	public Inscription() {
		super();
	}

	public Integer getIdInscription() {
		return idInscription;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdSession() {
		return idSession;
	}

	public void setIdSession(Integer idSession) {
		this.idSession = idSession;
	}

	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", idClient=" + idClient + ", idSession=" + idSession
				+ "]";
	}

}
