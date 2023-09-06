package fr.eni.enchere.bo;

import java.util.Date;
import java.util.List;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEnchere;
	private Date dateFinEnchere;
	private Integer prixInitial;
	private Integer prixVente;
	private String lienImg;

	private Categorie categorieArticle;
	
	private Utilisateur utilisateur;
	
	private Retrait lieuRetrait;
	
	private List<Enchere> lstEncheres;
	
	public ArticleVendu() {
		super();
	}

	public ArticleVendu(String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere,
			Integer prixInitial, Integer prixVente, String lienImg) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.lienImg = lienImg;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public Categorie getCategorie() {
		return categorieArticle;
	}

	public void setCategorie(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getLienImg() {
		return lienImg;
	}

	public void setLienImg(String lienImg) {
		this.lienImg = lienImg;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", lienImg=" + lienImg + ", categorieArticle="
				+ categorieArticle + ", utilisateur=" + utilisateur + ", lieuRetrait=" + lieuRetrait + ", lstEncheres="
				+ lstEncheres + "]";
	}

	
	
}
