package fr.eni.enchere.bo;

import java.time.LocalDateTime;

import fr.eni.right.bo.User;

public class Enchere {
	private Integer noEnchere;
	private Integer noUtilisateur;
	private Integer noArticle;
	private LocalDateTime dateEnchere;
	private Integer montant;
	
	private User user;
	private ArticleVendu articleVendu;
	
	
	public Enchere() {
		super();
	}


	public Enchere(Integer noUtilisateur, Integer noArticle, LocalDateTime dateEnchere, Integer montant) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montant = montant;
	}


	public Integer getNoEnchere() {
		return noEnchere;
	}


	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}


	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}


	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}


	public Integer getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
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
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}


	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}


	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle
				+ ", dateEnchere=" + dateEnchere + ", montant=" + montant + ", user=" + user + ", articleVendu="
				+ articleVendu + "]";
	}

	
	
	
}
