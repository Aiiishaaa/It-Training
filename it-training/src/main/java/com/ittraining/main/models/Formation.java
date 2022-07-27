package com.ittraining.main.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formations")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormation;

	@ManyToOne
	@JoinColumn(name = "id_theme")
	private Theme theme;
	private double prix;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prerequis")
	private Prerequis prerequis;
	private String descriptionBreve;
	private String descriptionLongue;
	private String programme;

	@ManyToOne
	@JoinColumn(name = "id_employe")
	private Employe employe;

	private String intitule;
	private int nbHeures;

	public Formation() {
		super();
	}

	public Formation(Theme theme, double prix, Prerequis prerequis, String descriptionBreve, String descriptionLongue,
			String programme, Employe employe, String intitule, int nbHeures) {
		super();
		this.theme = theme;
		this.prix = prix;
		this.prerequis = prerequis;
		this.descriptionBreve = descriptionBreve;
		this.descriptionLongue = descriptionLongue;
		this.programme = programme;
		this.employe = employe;
		this.intitule = intitule;
		this.nbHeures = nbHeures;
	}

	public Integer getIdFormation() {
		return idFormation;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Prerequis getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(Prerequis prerequis) {
		this.prerequis = prerequis;
	}

	public String getDescriptionBreve() {
		return descriptionBreve;
	}

	public void setDescriptionBreve(String descriptionBreve) {
		this.descriptionBreve = descriptionBreve;
	}

	public String getDescriptionLongue() {
		return descriptionLongue;
	}

	public void setDescriptionLongue(String descriptionLongue) {
		this.descriptionLongue = descriptionLongue;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", theme=" + theme + ", prix=" + prix + ", prerequis="
				+ prerequis + ", descriptionBreve=" + descriptionBreve + ", descriptionLongue=" + descriptionLongue
				+ ", programme=" + programme + ", employe=" + employe + ", intitule=" + intitule + ", nbHeures="
				+ nbHeures + "]";
	}

}