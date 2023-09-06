package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.exception.DALException;

public class EnchereDAOMock implements EnchereDAO {
	
	public List<Enchere> lstEncheres = new ArrayList<>();

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		lstEncheres.add(enchere);
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		return lstEncheres;
	}
	
	
	
}
