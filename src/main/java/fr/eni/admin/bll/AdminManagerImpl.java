package fr.eni.admin.bll;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bo.Utilisateur;
import fr.eni.admin.dal.DAOFact;
import fr.eni.admin.dal.AdminDAO;

public class AdminManagerImpl implements AdminManager {
	private AdminDAO dao = DAOFact.getAdminDAO();

	@Override
	public void removeUser(Integer idUser) {
		try {
			dao.removeUser(idUser);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void desactivateUser(Integer idUser) {
		try {
			dao.desactivateUser(idUser);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	
}
