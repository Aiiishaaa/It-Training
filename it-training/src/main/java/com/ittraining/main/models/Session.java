package com.ittraining.main.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dateDebut;
	private LocalDate dateFin;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_formation")
	private Formation formation;

	@ManyToOne
	@JoinColumn(name = "id_formateur")
	private Formateur formateur;

	@ManyToOne
	@JoinColumn(name = "id_adresse")
	private Adresse adresse;

	@ManyToMany
	@JoinTable(name = "sessions_users", joinColumns = { @JoinColumn(name = "id_session") }, inverseJoinColumns = {
			@JoinColumn(name = "id_user") })
	private List<User> users = new ArrayList<User>();

	public Session() {
		super();
	}

	public Session(LocalDate dateDebut, LocalDate dateFin, Formation formation, Formateur formateur, Adresse adresse,
			List<User> users) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.formation = formation;
		this.formateur = formateur;
		this.adresse = adresse;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", formation="
				+ formation + ", formateur=" + formateur + ", adresse=" + adresse + ", users=" + users + "]";
	}

}
