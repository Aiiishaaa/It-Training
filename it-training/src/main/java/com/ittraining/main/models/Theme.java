package com.ittraining.main.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "themes")
public class Theme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomTheme;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_domaine")
	private Domaine domaine;
	
	@JsonIgnore
	@OneToMany(mappedBy = "theme")
	private List<Formation> formations = new ArrayList<Formation>();
	
	public Theme() {
		super();
	}

	public Theme(String nomTheme, Domaine domaine) {
		super();
		this.nomTheme = nomTheme;
		this.domaine = domaine;
	}

	public Integer getId() {
		return id;
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
		return "Theme [idTheme=" + id + ", nomTheme=" + nomTheme + ", domaine=" + domaine + "]";
	}

}
