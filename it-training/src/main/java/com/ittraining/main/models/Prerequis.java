package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prerequis")
public class Prerequis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPrerequis;
	private String qcmPrerequis;
	private boolean validationPrerequis;

	@OneToOne
	@JoinColumn(name = "id_formation")
	@JsonIgnore
	private Formation formation;

	public Prerequis() {
		super();
	}

	public Prerequis(String qcmPrerequis, boolean validationPrerequis, Formation formation) {
		super();
		this.qcmPrerequis = qcmPrerequis;
		this.validationPrerequis = validationPrerequis;
		this.formation = formation;
	}

	public Integer getIdPrerequis() {
		return idPrerequis;
	}

	public String getQcmPrerequis() {
		return qcmPrerequis;
	}

	public void setQcmPrerequis(String qcmPrerequis) {
		this.qcmPrerequis = qcmPrerequis;
	}

	public boolean isValidationPrerequis() {
		return validationPrerequis;
	}

	public void setValidationPrerequis(boolean validationPrerequis) {
		this.validationPrerequis = validationPrerequis;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Prerequis [idPrerequis=" + idPrerequis + ", qcmPrerequis=" + qcmPrerequis + ", validationPrerequis="
				+ validationPrerequis + ", formation=" + formation + "]";
	}

}
