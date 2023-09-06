package fr.eni.enchere.bll.manager;

import java.util.List;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.exception.DALException;

public interface CategorieManager {

	public void addCategorie(Categorie categorie) throws DALException;
	public List<Categorie> getAllCategorie() throws DALException;
	public Categorie getCategorieById(Integer idCat) throws DALException;
	public void updateCategorie(Categorie categorie, Integer idCat) throws DALException;
	public void removeCategorie(Integer idCat) throws BLLException;
	
}
