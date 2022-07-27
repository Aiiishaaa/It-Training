package com.ittraining.main.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSession;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_formation", referencedColumnName = "id_formation")
	private Formation formation;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_formateur", referencedColumnName = "id_formateur")
	private Formateur formateur;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
	private Adresse adresse;
	
	public Session() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Session(LocalDate dateDebut, LocalDate dateFin, Formation formation, Formateur formateur,
			Adresse adresse) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.formation = formation;
		this.formateur = formateur;
		this.adresse = adresse;
	}

	public Integer getIdSession() {
		return idSession;
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

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", formation="
				+ formation + ", formateur=" + formateur + ", adresse=" + adresse + "]";
	}

	
	
}
