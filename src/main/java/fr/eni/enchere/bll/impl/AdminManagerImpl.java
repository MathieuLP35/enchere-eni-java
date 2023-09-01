package fr.eni.enchere.bll.impl;

import fr.eni.enchere.bll.manager.AdminManager;
import fr.eni.enchere.dal.fact.DAOFact;
import fr.eni.enchere.dal.dao.AdminDAO;
import fr.eni.enchere.dal.dao.UtilisateurDAO;
import fr.eni.enchere.dal.exception.DALException;

public class AdminManagerImpl implements AdminManager {
	private AdminDAO dao = DAOFact.getAdminDAO();
	private UtilisateurDAO daoUtilisateur = DAOFact.getUserDAO();

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
			if(daoUtilisateur.findById(idUser).getIsActive()) {
				dao.desactivateUser(idUser, false);
			} else {
				dao.desactivateUser(idUser, true);
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	
}
