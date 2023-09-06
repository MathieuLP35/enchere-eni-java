package fr.eni.enchere.bll.impl;

import java.util.List;

import fr.eni.enchere.bll.manager.RetraitManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.dao.RetraitDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.fact.DAOFact;

public class RetraitManagerImpl implements RetraitManager {

	private RetraitDAO dao = DAOFact.getRetraitDAO();
	
	@Override
	public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		dao.insertRetrait(retrait, articleVendu);
	}

	@Override
	public List<Retrait> getAllRetrait() throws DALException {
		return dao.getAllRetrait();
	}
}
