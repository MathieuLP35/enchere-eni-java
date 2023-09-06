package fr.eni.enchere.bll.impl;

import java.util.List;

import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.fact.DAOFact;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.exception.DALException;

public class EnchereManagerImpl implements EnchereManager{

	private EnchereDAO dao = DAOFact.getEnchereDAO();



	
	@Override
	public void addEnchere(Enchere enchere) throws DALException {
		dao.insertEnchere(enchere);
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		return dao.getAllEnchere();
	}

}
