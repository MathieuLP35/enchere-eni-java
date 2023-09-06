package fr.eni.enchere.ihm.model;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;

public class AccueilModel {
	
	private String message = "";
	private List<Categorie> lstCategories = new ArrayList<>();
	private List<ArticleVendu> lstArticlesVendus = new ArrayList<>();
	

	public AccueilModel() {}
	
	public AccueilModel(String message, List<Categorie> lstCategories, List<ArticleVendu> lstArticlesVendus) {
		super();
		this.message = message;
		this.lstCategories = lstCategories;
		this.lstArticlesVendus = lstArticlesVendus;
	}

	public List<Categorie> getLstCategories() {
		return lstCategories;
	}

	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ArticleVendu> getLstArticlesVendus() {
		return lstArticlesVendus;
	}

	public void setLstArticlesVendus(List<ArticleVendu> lstArticlesVendus) {
		this.lstArticlesVendus = lstArticlesVendus;
	}
}
