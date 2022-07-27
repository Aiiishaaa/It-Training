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
	private Client client;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_session", referencedColumnName = "id_session")
	private Session session;

	public Inscription() {
		super();
		//TODO Auto-generated constructor stub
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