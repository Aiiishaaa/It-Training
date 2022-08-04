package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "formations")
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_domaine")
	private Domaine domaine;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_theme")
	private Theme theme;

	private double prix;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formation")
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
	@JoinColumn(name = "id_user")
	private User user;

	private String intitule;
	private int nbHeures;
	private String urlImage;

	public Formation() {
		super();
	}

	public Formation(Domaine domaine, Theme theme, double prix, List<Session> sessions, Prerequis prerequis,
			String descriptionBreve, String descriptionLongue, String programme, User user, String intitule,
			int nbHeures, String urlImage) {
		super();
		this.domaine = domaine;
		this.theme = theme;
		this.prix = prix;
		this.sessions = sessions;
		this.prerequis = prerequis;
		this.descriptionBreve = descriptionBreve;
		this.descriptionLongue = descriptionLongue;
		this.programme = programme;
		this.user = user;
		this.intitule = intitule;
		this.nbHeures = nbHeures;
		this.urlImage = urlImage;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", domaine=" + domaine + ", theme=" + theme + ", prix=" + prix + ", sessions="
				+ sessions + ", prerequis=" + prerequis + ", descriptionBreve=" + descriptionBreve
				+ ", descriptionLongue=" + descriptionLongue + ", programme=" + programme + ", user=" + user
				+ ", intitule=" + intitule + ", nbHeures=" + nbHeures + ", urlImage=" + urlImage + "]";
	}

}