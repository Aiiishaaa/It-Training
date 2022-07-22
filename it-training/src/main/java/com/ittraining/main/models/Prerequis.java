package com.ittraining.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prerequis")
public class Prerequis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPrerequis;
	private String qcmPrerequis;
	private boolean validationPrerequis;
	
	public Prerequis() {
		super();
	}

	public Prerequis(String qcmPrerequis, boolean validationPrerequis) {
		super();
		this.qcmPrerequis = qcmPrerequis;
		this.validationPrerequis = validationPrerequis;
	}

	public Integer getIdPrerequis() {
		return idPrerequis;
	}

	public void setIdPrerequis(Integer idPrerequis) {
		this.idPrerequis = idPrerequis;
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

	@Override
	public String toString() {
		return "Prerequis [idPrerequis=" + idPrerequis + ", qcmPrerequis=" + qcmPrerequis + ", validationPrerequis="
				+ validationPrerequis + "]";
	}

}
