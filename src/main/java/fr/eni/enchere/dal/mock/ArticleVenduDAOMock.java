package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.dao.ArticleDAO;
import fr.eni.enchere.dal.exception.DALException;

public class ArticleVenduDAOMock implements ArticleDAO {
	
	public List<ArticleVendu> lstArticles = new ArrayList<>();

	@Override
	public void insertArticleVendu(ArticleVendu articleVendu) throws DALException {
		lstArticles.add(articleVendu);
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws DALException {
		return lstArticles;
	}

	@Override
	public ArticleVendu findByIdArticle(Integer idArticle) throws DALException {
		return (ArticleVendu) lstArticles.stream().filter(a->a.getNoArticle() == idArticle);
	}

	@Override
	public List<ArticleVendu> getArticlesFilter(Integer idCat, String nomArticle, Boolean enchereOuverteFilter,
			Boolean enchereEnCoursFilter, Boolean enchereRemporterFilter, Boolean venteEnchereEnCours,
			Boolean venteEnchereNonDébutées, Boolean venteEnchereTerminées, Integer idUtilisateur) throws DALException {
		
		return null;
	}

}
