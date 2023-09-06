package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.dao.CategorieDAO;
import fr.eni.enchere.dal.exception.DALException;

public class CategorieDAOMock implements CategorieDAO {
	public List<Categorie> lstCategorie = new ArrayList<>();

	@Override
	public void insertCategorie(Categorie categorie) throws DALException {
		lstCategorie.add(categorie);
	}

	@Override
	public List<Categorie> getAllCategorie() throws DALException {
		return lstCategorie;
	}

	@Override
	public Categorie findByIdCategorie(Integer idCategorie) throws DALException {
		// TODO Auto-generated method stub
		return (Categorie) lstCategorie.stream().filter(c -> c.getNoCategorie() == idCategorie);
	}

	@Override
	public Categorie getCategorieById(Integer idCat) throws DALException {
		
		return null;
	}

	@Override
	public void updateCategorie(Categorie categorie, Integer idCat) throws DALException {
		
		
	}

	@Override
	public void removeCategorie(Integer idCat) throws DALException {
		
	}

}
