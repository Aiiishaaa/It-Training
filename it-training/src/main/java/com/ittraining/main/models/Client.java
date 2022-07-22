package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idClient;
	private String nomClient;
	private String prenomClient;
	private String passwordClient;
	private String emailClient;

	public Client(Integer idClient, String nomClient, String prenomClient, String passwordClient, String emailClient) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.passwordClient = passwordClient;
		this.emailClient = emailClient;
	}

	public Client() {
		super();
	}

	public Integer getIdClient() {
		return idClient;
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

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", passwordClient=" + passwordClient + ", emailClient=" + emailClient + "]";
	}

}