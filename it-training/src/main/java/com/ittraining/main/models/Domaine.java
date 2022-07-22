package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domaines")

public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDomaine;
	private String nomDomaine;
	
	public Domaine() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Domaine(String nomDomaine) {
		super();
		this.nomDomaine = nomDomaine;
	}

	public Integer getIdDomaine() {
		return idDomaine;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

	@Override
	public String toString() {
		return "Domaine [idDomaine=" + idDomaine + ", nomDomaine=" + nomDomaine + "]";
	}
	
	
	
}
