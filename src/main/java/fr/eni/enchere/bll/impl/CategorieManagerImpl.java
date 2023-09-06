package fr.eni.enchere.bll.impl;

import java.util.List;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bll.manager.CategorieManager;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.dao.CategorieDAO;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.fact.DAOFact;

public class CategorieManagerImpl implements CategorieManager {

	private CategorieDAO dao = DAOFact.getCategorieDAO();
	
	@Override
	public void addCategorie(Categorie categorie) throws DALException {
		dao.insertCategorie(categorie);
	}

	@Override
	public List<Categorie> getAllCategorie() throws DALException {
		return dao.getAllCategorie();
	}
	@Override
	public void updateCategorie(Categorie categorie, Integer idCat) throws DALException {
		dao.updateCategorie(categorie, idCat);
	}

	@Override
	public void removeCategorie(Integer idCat) throws BLLException {
		if(getCategorieById(idCat) != null) {
			throw new BLLException("Cette catégorie contient des articles et ne peut pas être supprimé.");
		} else {
			try {
				dao.removeCategorie(idCat);
			} catch (DALException e) {
				e.printStackTrace();
				throw new BLLException("Cette catégorie contient des articles et ne peut pas être supprimé.");
			}
		}
	}

	@Override
	public Categorie getCategorieById(Integer idCat){
		try {
			return dao.getCategorieById(idCat);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}
}
