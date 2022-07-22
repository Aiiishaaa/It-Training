package com.ittraining.main.models;

public class Formation {

	@Id 
	@
	
	private Integer idFormation;
	private String idTheme;
	private double prix;
	private Integer idPrerequis;
	private String description;
	private String programme;
	private Integer idEmploye;
	private String intitule;

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Formation(String idTheme, double prix, Integer idPrerequis, String description, String programme,
			Integer idEmploye, String intitule) {
		super();
		this.idTheme = idTheme;
		this.prix = prix;
		this.idPrerequis = idPrerequis;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", idTheme=" + idTheme + ", prix=" + prix + ", idPrerequis="
				+ idPrerequis + ", description=" + description + ", programme=" + programme + ", idEmploye=" + idEmploye
				+ ", intitule=" + intitule + "]";
	}

}
