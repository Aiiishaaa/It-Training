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

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_theme", referencedColumnName = "id_theme")
	private String idTheme;
	private double prix;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_prerequis", referencedColumnName = "id_prerequis")
	private Integer idPrerequis;
	private String descriptionBreve;
	private String descriptionLongue;
	private String programme;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_employe", referencedColumnName = "id_employe")
	private Employe employe;
	
	private String intitule;
	private int nbHeures;

	public Formation() {
		super();
	}

	public Formation(String idTheme, double prix, Integer idPrerequis, String descriptionBreve, String descriptionLongue, String programme,
			Integer idEmploye, String intitule) {
		super();
		this.idTheme = idTheme;
		this.prix = prix;
		this.idPrerequis = idPrerequis;
		this.descriptionBreve = descriptionBreve;
		this.descriptionLongue = descriptionLongue;
		this.programme = programme;
		this.idEmploye = idEmploye;
		this.intitule = intitule;
	}

	public Integer getIdFormation() {
		return idFormation;
	}

	public String getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(String idTheme) {
		this.idTheme = idTheme;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Integer getIdPrerequis() {
		return idPrerequis;
	}

	public void setIdPrerequis(Integer idPrerequis) {
		this.idPrerequis = idPrerequis;
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

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
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
		return "Formation [idFormation=" + idFormation + ", idTheme=" + idTheme + ", prix=" + prix + ", idPrerequis="
				+ idPrerequis + ", descriptionBreve=" + descriptionBreve + ", descriptionLongue=" + descriptionLongue + ", programme=" + programme + ", idEmploye=" + idEmploye
				+ ", intitule=" + intitule +", nbHeures=" + nbHeures + "]";
	}
}
