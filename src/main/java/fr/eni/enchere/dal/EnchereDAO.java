package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

public interface EnchereDAO {
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException;
	public List<Utilisateur> getAllUtilisateur() throws DALException;
	public void insertArticleVendu(ArticleVendu articleVendu) throws DALException;
	public List<ArticleVendu> getAllArticleVendu() throws DALException;
	public void insertCategorie(Categorie categorie) throws DALException;
	public List<Categorie> getAllCategorie() throws DALException;
	public void insertRetrait(Retrait retrait) throws DALException;
	public List<Retrait> getAllRetrait() throws DALException;
	public void insertEnchere(Enchere enchere) throws DALException;
	public List<Enchere> getAllEnchere() throws DALException;
	
	
}
