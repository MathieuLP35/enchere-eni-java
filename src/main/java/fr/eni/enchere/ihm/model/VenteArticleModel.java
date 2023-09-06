package fr.eni.enchere.ihm.model;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;

public class VenteArticleModel {
	
	private String message = "";
	private List<Categorie> lstCategories = new ArrayList<>();
	private List<Enchere> lstEncheres = new ArrayList<>();
	private Retrait lieuRetrait;

	public VenteArticleModel() {}
	
	public VenteArticleModel(String message, List<Categorie> lstCategories, List<Enchere> lstEncheres, Retrait lieuRetrait) {
		super();
		this.message = message;
		this.lstCategories = lstCategories;
		this.lstEncheres = lstEncheres;
		this.lieuRetrait = lieuRetrait;
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

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
}
