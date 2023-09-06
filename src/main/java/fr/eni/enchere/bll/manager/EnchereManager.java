package fr.eni.enchere.bll.manager;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.exception.DALException;

public interface EnchereManager {

	public ArticleVendu findByIdArticleVendu(Integer idArticle) throws DALException;
	public Retrait findByIdRetrait(Integer idArticle) throws DALException;
	

	public void addArticle(ArticleVendu articleVendu) throws DALException;
	public List<ArticleVendu> getAllArticleVendu() throws DALException;
	
	public void addCategorie(Categorie categorie) throws DALException;
	public List<Categorie> getAllCategorie() throws DALException;
	
	public void addEnchere(Enchere enchere) throws DALException;
	public List<Enchere> getAllEnchere() throws DALException;
	
	public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws DALException;
	public List<Retrait> getAllRetrait() throws DALException;
	public ArticleVendu insertPrixArticleVendu(Enchere enchere, Integer montant) throws DALException;
}
