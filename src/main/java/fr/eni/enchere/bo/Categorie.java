package fr.eni.enchere.bo;

import java.util.List;

public class Categorie {
	private Integer noCategorie;
	private String libelle;
	private List<ArticleVendu> lstArticleVendus;
	
	public Categorie() {
		super();
	}
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public Integer getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<ArticleVendu> getLstArticleVendus() {
		return lstArticleVendus;
	}
	public void setLstArticleVendus(List<ArticleVendu> lstArticleVendus) {
		this.lstArticleVendus = lstArticleVendus;
	}
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", lstArticleVendus="
				+ lstArticleVendus + "]";
	}
	
	
	
}
