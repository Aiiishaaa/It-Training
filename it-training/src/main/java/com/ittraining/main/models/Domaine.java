package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "domaines")
public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomDomaine;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Theme> themes = new ArrayList<Theme>();

	public Domaine() {
		super();
	}

	public Domaine(String nomDomaine, List<Theme> themes) {
		super();
		this.nomDomaine = nomDomaine;
		this.themes = themes;
	}

	public Integer getId() {
		return id;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	@Override
	public String toString() {
		return "Domaine [idDomaine=" + id + ", nomDomaine=" + nomDomaine + ", themes=" + themes + "]";
	}

}
