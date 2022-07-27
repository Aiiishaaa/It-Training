package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "inscription")
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInscription;

	@ManyToOne
	@JoinColumn(name = "id_client")
	@JsonIgnore
	private Client client;

	@ManyToOne
	@JoinColumn(name = "id_session")
	@JsonIgnore
	private Session session;

	public Inscription() {
		super();
	}

	public Inscription(Client client, Session session) {
		super();
		this.client = client;
		this.session = session;
	}

	public Integer getIdInscription() {
		return idInscription;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", client=" + client + ", session=" + session + "]";
	}

}