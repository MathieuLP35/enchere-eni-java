package fr.eni.enchere.bll.impl;

import java.util.List;

import fr.eni.enchere.bll.manager.AdminManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.fact.DAOFact;
import fr.eni.enchere.dal.dao.AdminDAO;
import fr.eni.enchere.dal.exception.DALException;

public class AdminManagerImpl implements AdminManager {
	private AdminDAO dao = DAOFact.getAdminDAO();

	@Override
	public void removeUser(Integer idUser) {
		try {
			dao.removeUser(idUser);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void desactivateUser(Integer idUser) {
		try {
			dao.desactivateUser(idUser);
		} catch (DALException e) {
			e.printStackTrace();
		}	
	}

	
}
