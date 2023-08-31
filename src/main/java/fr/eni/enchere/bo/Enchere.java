package fr.eni.enchere.bo;

import java.time.LocalDateTime;

import fr.eni.right.bo.User;

public class Enchere {
	private Integer noEnchere;
	private LocalDateTime dateEnchere;
	private Integer montant;
	
	private User user;
	private ArticleVendu articleVendu;
	
	
	public Enchere() {
		super();
	}


	public Enchere(LocalDateTime dateEnchere, Integer montant, User user, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant = montant;
		this.user = user;
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
		return "Enchere [noEnchere=" + noEnchere
				+ ", dateEnchere=" + dateEnchere + ", montant=" + montant + ", user=" + user.toString() + ", articleVendu="
				+ articleVendu.toString() + "]";
	}

	
	
	
}
