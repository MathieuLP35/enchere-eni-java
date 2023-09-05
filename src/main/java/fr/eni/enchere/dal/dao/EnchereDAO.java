package fr.eni.enchere.dal.dao;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;


public interface EnchereDAO {

	public void insertArticleVendu(ArticleVendu articleVendu) throws DALException;
	public List<ArticleVendu> getAllArticleVendu() throws DALException;
	public ArticleVendu findByIdArticle(Integer idArticle) throws DALException;
	public void insertCategorie(Categorie categorie) throws DALException;
	public List<Categorie> getAllCategorie() throws DALException;
	public Categorie findByIdCategorie(Integer idCategorie) throws DALException;
	public void insertRetrait(Retrait retrait, ArticleVendu articleVendu) throws DALException;
	public List<Retrait> getAllRetrait() throws DALException;
	public Retrait findByIdRetrait(Integer idRetrait) throws DALException;
	public void insertEnchere(Enchere enchere) throws DALException;
	public List<Enchere> getAllEnchere() throws DALException;
	
	public List<Enchere> getEncheresFilter(Integer idCat, String nomArticle, 
			Boolean enchereOuverteFilter, Boolean enchereEnCoursFilter, Boolean enchereRemporterFilter, 
			Boolean venteEnchereEnCours, Boolean venteEnchereNonDébutées, Boolean venteEnchereTerminées, Integer idUtilisateur) throws DALException;
	
	public Categorie getCategorieById(Integer idCat) throws DALException;
	
	public void updateCategorie(Categorie categorie, Integer idCat) throws DALException;
	
	public void removeCategorie(Integer idCat) throws DALException;

}
