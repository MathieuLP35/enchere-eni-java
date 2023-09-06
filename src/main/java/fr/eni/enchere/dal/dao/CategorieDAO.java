package fr.eni.enchere.dal.dao;

import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.exception.DALException;

public interface CategorieDAO {

	public void insertCategorie(Categorie categorie) throws DALException;
	public List<Categorie> getAllCategorie() throws DALException;
	public Categorie findByIdCategorie(Integer idCategorie) throws DALException;
	public Categorie getCategorieById(Integer idCat) throws DALException;
	public void updateCategorie(Categorie categorie, Integer idCat) throws DALException;
	public void removeCategorie(Integer idCat) throws DALException;
}
