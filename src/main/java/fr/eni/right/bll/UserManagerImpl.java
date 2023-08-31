package fr.eni.right.bll;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bo.User;
import fr.eni.right.dal.DAOFact;
import fr.eni.right.dal.UserDAO;

public class UserManagerImpl implements UserManager {
	private UserDAO dao = DAOFact.getUserDAO();
	
	@Override
	public void addUser(User user) {
		try {
			dao.insert(user);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User check(String login, String password) {
		List<User> users;
		try {
			users = dao.findByLoginAndPassword(login, password);
			if(users.size()>0) {
				return users.get(0);
			}
			else {
				return null;
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(User user, Integer noUtilisateur){
		try {
			dao.update(user, noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
