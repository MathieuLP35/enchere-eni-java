package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.right.bo.Utilisateur;


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

}
