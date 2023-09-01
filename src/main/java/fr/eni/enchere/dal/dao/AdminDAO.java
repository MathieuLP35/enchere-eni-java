package fr.eni.enchere.dal.dao;

import java.util.List;

import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.bo.Utilisateur;


public interface AdminDAO {
	public void removeUser(Integer idUser) throws DALException;
	public void desactivateUser(Integer idUser) throws DALException;
}
