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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "domaine")
	private List<Theme> themes = new ArrayList<Theme>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "domaine")
	private List<Formation> formations = new ArrayList<Formation>();

	public Domaine() {
		super();
	}

	public Domaine(String nomDomaine, List<Theme> themes, List<Formation> formations) {
		super();
		this.nomDomaine = nomDomaine;
		this.themes = themes;
		this.formations = formations;
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

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Domaine [id=" + id + ", nomDomaine=" + nomDomaine + ", themes=" + themes + ", formations=" + formations
				+ "]";
	}

	
}
