package fr.eni.enchere.dal.dao;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.exception.DALException;

public interface RetraitDAO {

	public void insertRetrait(Retrait retrait, ArticleVendu articleVendu) throws DALException;
	public List<Retrait> getAllRetrait() throws DALException;
	public Retrait findByIdRetrait(Integer idRetrait) throws DALException;
}
