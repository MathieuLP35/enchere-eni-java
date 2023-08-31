package fr.eni.admin.bll;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bo.User;
import fr.eni.right.dal.DAOFact;
import fr.eni.right.dal.UserDAO;

public class AdminManagerImpl implements AdminManager {
	private UserDAO dao = DAOFact.getUserDAO();

	@Override
	public List<User> removeUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
