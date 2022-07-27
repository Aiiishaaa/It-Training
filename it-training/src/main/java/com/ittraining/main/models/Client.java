package com.ittraining.main.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

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

	@OneToMany
	@JoinColumn(name = "id_inscription")
	@JsonIgnore
	private List<Inscription> inscriptions = new ArrayList<Inscription>();

	public Client() {
		super();
	}

	public Client(String nomClient, String prenomClient, String passwordClient, String emailClient,
			List<Inscription> inscriptions) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.passwordClient = passwordClient;
		this.emailClient = emailClient;
		this.inscriptions = inscriptions;
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

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient
				+ ", passwordClient=" + passwordClient + ", emailClient=" + emailClient + ", inscriptions="
				+ inscriptions + "]";
	}

}