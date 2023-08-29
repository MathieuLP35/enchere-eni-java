package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;

public interface EnchereManager {

	public void addArticle(ArticleVendu articleVendu) throws DALException;
	public List<ArticleVendu> getAllArticleVendu() throws DALException;
	
	public void addCategorie(Categorie categorie) throws DALException;
	public List<Categorie> getAllCategorie() throws DALException;
	
	public void addEnchere(Enchere enchere) throws DALException;
	public List<Enchere> getAllEnchere() throws DALException;
	
	public void addUtilisateur(Utilisateur utilisateur) throws DALException;
	public List<Utilisateur> getAllUtilisateur() throws DALException;
	
	public void addRetrait(Retrait retrait) throws DALException;
	public List<Retrait> getAllRetrait() throws DALException;
}