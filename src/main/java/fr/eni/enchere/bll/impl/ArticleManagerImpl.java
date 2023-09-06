package fr.eni.enchere.bll.impl;

import java.util.List;

import fr.eni.enchere.bll.manager.ArticleManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.dao.ArticleDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.fact.DAOFact;

public class ArticleManagerImpl implements ArticleManager {
	
	private ArticleDAO dao = DAOFact.getArticleDAO();

	@Override
	public void addArticle(ArticleVendu articleVendu) throws DALException {
		dao.insertArticleVendu(articleVendu);
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws DALException {
		return dao.getAllArticleVendu();
	}
	@Override
	public ArticleVendu findByIdArticleVendu(Integer idArticleVendu) throws DALException {
		return dao.findByIdArticle(idArticleVendu);
	}

	@Override
	public List<ArticleVendu> getArticlesFilter(Integer idCat, String nomArticle, 
			Boolean enchereOuverteFilter, Boolean enchereEnCoursFilter, Boolean enchereRemporterFilter, 
			Boolean venteEnchereEnCours, Boolean venteEnchereNonDébutées, Boolean venteEnchereTerminées, Integer idUtilisateur) throws DALException {
		return dao.getArticlesFilter(idCat, nomArticle, 
				enchereOuverteFilter, enchereEnCoursFilter, enchereRemporterFilter, 
				venteEnchereEnCours, venteEnchereNonDébutées, venteEnchereTerminées, idUtilisateur);
	}
	
	@Override
	public ArticleVendu insertPrixArticleVendu(Enchere enchere, Integer montant) throws DALException {
		return dao.insertPrixArticleVendu(enchere, montant);
	}
}
