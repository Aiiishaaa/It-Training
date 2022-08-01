package com.ittraining.main.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String nomClient;
	private String prenomClient;
	private String passwordClient;
	private String emailClient;

	@OneToMany(mappedBy = "clients")
	private List<Session> sessions = new ArrayList<Session>();

	public Client() {
		super();
	}

	public Client(String nomClient, String prenomClient, String passwordClient, String emailClient,
			List<Session> sessions) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.passwordClient = passwordClient;
		this.emailClient = emailClient;
		this.sessions = sessions;
	}

	public Integer getId() {
		return id;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getPasswordClient() {
		return passwordClient;
	}

	public void setPasswordClient(String passwordClient) {
		this.passwordClient = passwordClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + id + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", passwordClient=" + passwordClient + ", emailClient=" + emailClient + ", sessions=" + sessions
				+ "]";
	}

}