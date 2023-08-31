package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFact;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereManagerImpl implements EnchereManager{

	private EnchereDAO dao = DAOFact.getEnchereDAO();

	@Override
	public void addArticle(ArticleVendu articleVendu) throws DALException {
		dao.insertArticleVendu(articleVendu);
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws DALException {
		return dao.getAllArticleVendu();
	}

	@Override
	public void addCategorie(Categorie categorie) throws DALException {
		dao.insertCategorie(categorie);
	}

	@Override
	public List<Categorie> getAllCategorie() throws DALException {
		return dao.getAllCategorie();
	}

	@Override
	public void addEnchere(Enchere enchere) throws DALException {
		dao.insertEnchere(enchere);
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		System.out.println(dao.getAllEnchere());
		return dao.getAllEnchere();
	}

	@Override
	public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		dao.insertRetrait(retrait, articleVendu);
	}

	@Override
	public List<Retrait> getAllRetrait() throws DALException {
		// TODO Auto-generated method stub
		return dao.getAllRetrait();
	}
}
