package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "formations")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_domaine")
	private Domaine domaine;

	@ManyToOne
	@JoinColumn(name = "id_theme")
	private Theme theme;
	private double prix;

	@OneToMany
	@JoinColumn(name = "id_session")
	private List<Session> sessions = new ArrayList<Session>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prerequis")
	private Prerequis prerequis;
	private String descriptionBreve;
	@Type(type = "text")
	private String descriptionLongue;
	@Type(type = "text")
	private String programme;

	@ManyToOne
	@JoinColumn(name = "id_employe")
	private Employe employe;

	private String intitule;
	private int nbHeures;

	public Formation() {
		super();
	}

	public Formation(Domaine domaine, Theme theme, double prix, List<Session> sessions, Prerequis prerequis,
			String descriptionBreve, String descriptionLongue, String programme, Employe employe, String intitule,
			int nbHeures) {
		super();
		this.domaine = domaine;
		this.theme = theme;
		this.prix = prix;
		this.sessions = sessions;
		this.prerequis = prerequis;
		this.descriptionBreve = descriptionBreve;
		this.descriptionLongue = descriptionLongue;
		this.programme = programme;
		this.employe = employe;
		this.intitule = intitule;
		this.nbHeures = nbHeures;
	}

	public Integer getId() {
		return id;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
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

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", domaine=" + domaine + ", theme=" + theme + ", prix=" + prix + ", sessions="
				+ sessions + ", prerequis=" + prerequis + ", descriptionBreve=" + descriptionBreve
				+ ", descriptionLongue=" + descriptionLongue + ", programme=" + programme + ", employe=" + employe
				+ ", intitule=" + intitule + ", nbHeures=" + nbHeures + "]";
	}

}