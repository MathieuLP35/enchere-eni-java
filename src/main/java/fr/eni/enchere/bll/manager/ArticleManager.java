package fr.eni.enchere.bll.manager;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.dal.exception.DALException;

public interface ArticleManager {
	public void addArticle(ArticleVendu articleVendu) throws DALException;
	public List<ArticleVendu> getAllArticleVendu() throws DALException;
	
	public List<ArticleVendu> getArticlesFilter(Integer idCat, String nomArticle, 
			Boolean enchereOuverteFilter, Boolean enchereEnCoursFilter, Boolean enchereRemporterFilter, 
			Boolean venteEnchereEnCours, Boolean venteEnchereNonDébutées, Boolean venteEnchereTerminées, Integer idUtilisateur) throws DALException;
	
	

}
