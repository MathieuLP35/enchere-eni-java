package fr.eni.enchere.bo;

import java.time.LocalDateTime;

public class Enchere {
	private Integer noEnchere;
	private Integer noUtilisateur;
	private Integer noArticle;
	private LocalDateTime dateEnchere;
	private Integer montant;
	
	
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


	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", noUtilisateur=" + noUtilisateur + ", noArticle=" + noArticle
				+ ", dateEnchere=" + dateEnchere + ", montant=" + montant + "]";
	}
	
	
}
