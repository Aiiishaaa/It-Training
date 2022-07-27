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
	private Integer idDomaine;

	public Theme() {
		super();
	}

	public Theme(String nomTheme, Integer idDomaine) {
		super();
		this.nomTheme = nomTheme;
		this.idDomaine = idDomaine;
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

	public Integer getIdDomaine() {
		return idDomaine;
	}

	public void setIdDomaine(Integer idDomaine) {
		this.idDomaine = idDomaine;
	}

	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", nomTheme=" + nomTheme + ", idDomaine=" + idDomaine + "]";
	}

}
