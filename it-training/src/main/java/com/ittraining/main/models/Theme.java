package com.ittraining.main.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "themes")
public class Theme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idTheme;
	private String nomTheme;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_domaine", referencedColumnName = "id_domaine")
	private Domaine domaine;

	public Theme() {
		super();
	}

	public Theme(String nomTheme, Domaine domaine) {
		super();
		this.nomTheme = nomTheme;
		this.domaine = domaine;
	}

	public Integer getIdTheme() {
		return idTheme;
	}

	public String getNomTheme() {
		return nomTheme;
	}

	public void setNomTheme(String nomTheme) {
		this.nomTheme = nomTheme;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", nomTheme=" + nomTheme + ", domaine=" + domaine + "]";
	}

	

}
