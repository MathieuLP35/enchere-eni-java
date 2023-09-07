package fr.eni.enchere.bo;

import java.time.LocalDateTime;


public class Enchere {
	private Integer noEnchere;
	private LocalDateTime dateEnchere;
	private Integer montant;
	
	private Utilisateur utilisateurVente;
	private ArticleVendu articleVendu;
	
	private Utilisateur encherisseur;
	
	
	public Enchere() {
		super();
	}


	public Enchere(LocalDateTime dateEnchere, Integer montant, Utilisateur utilisateurVente, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant = montant;
		this.utilisateurVente = utilisateurVente;
		this.articleVendu = articleVendu;
	}


	public Integer getNoEnchere() {
		return noEnchere;
	}


	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}


	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public Integer getMontant() {
		return montant;
	}


	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	
	public Utilisateur getUser() {
		return utilisateurVente;
	}


	public void setUser(Utilisateur user) {
		this.utilisateurVente = user;
	}


	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}


	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}


	public Utilisateur getEncherisseur() {
		return encherisseur;
	}


	public void setEncherisseur(Utilisateur utilisateur) {
		this.encherisseur = utilisateur;
	}


	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montant=" + montant + "]";
	}

	

	
	
	
}
