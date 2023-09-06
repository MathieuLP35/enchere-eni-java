package fr.eni.enchere.dal.dao;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.dal.exception.DALException;

public interface ArticleDAO {

	public void insertArticleVendu(ArticleVendu articleVendu) throws DALException;
	public List<ArticleVendu> getAllArticleVendu() throws DALException;
	public ArticleVendu findByIdArticle(Integer idArticle) throws DALException;
	public List<ArticleVendu> getArticlesFilter(Integer idCat, String nomArticle, 
			Boolean enchereOuverteFilter, Boolean enchereEnCoursFilter, Boolean enchereRemporterFilter, 
			Boolean venteEnchereEnCours, Boolean venteEnchereNonDébutées, Boolean venteEnchereTerminées, Integer idUtilisateur) throws DALException;
	

}
