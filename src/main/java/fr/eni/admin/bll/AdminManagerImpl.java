package fr.eni.admin.bll;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bo.User;
import fr.eni.admin.dal.DAOFact;
import fr.eni.admin.dal.AdminDAO;

public class AdminManagerImpl implements AdminManager {
	private AdminDAO dao = DAOFact.getAdminDAO();

	@Override
	public void removeUser(Integer idUser) {
		try {
			dao.removeUser(idUser);
		} catch (fr.eni.admin.dal.DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
