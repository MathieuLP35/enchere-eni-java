package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.dao.RetraitDAO;
import fr.eni.enchere.dal.exception.DALException;

public class RetraitDAOMock implements RetraitDAO {
	
	public List<Retrait> lstRetraits = new ArrayList<>();

	@Override
	public void insertRetrait(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		articleVendu.setLieuRetrait(retrait);
		lstRetraits.add(retrait);
	}

	@Override
	public List<Retrait> getAllRetrait() throws DALException {
		return lstRetraits;
	}

	@Override
	public Retrait findByIdRetrait(Integer idRetrait) throws DALException {
		return null;
	}
	
	

}
