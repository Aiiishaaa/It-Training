package com.ittraining.main.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSession;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_formation", referencedColumnName = "id_formation")
	private Integer idFormation;
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_formateur", referencedColumnName = "id_formateur")
	private Integer idFormateur;
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
	private Integer idAdresse;
	
	public Session() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Session(LocalDate dateDebut, LocalDate dateFin, Integer idFormation, Integer idFormateur,
			Integer idAdresse) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idFormation = idFormation;
		this.idFormateur = idFormateur;
		this.idAdresse = idAdresse;
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

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
	}

	public Integer getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(Integer idFormateur) {
		this.idFormateur = idFormateur;
	}

	public Integer getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", idFormation=" + idFormation + ", idFormateur=" + idFormateur + ", idAdresse=" + idAdresse + "]";
	}
	
	
}
