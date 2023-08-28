package fr.eni.right.bll;

import java.util.List;

import fr.eni.right.bo.User;
import fr.eni.right.dal.DAOFact;
import fr.eni.right.dal.UserDAO;

public class UserManagerImpl implements UserManager {
	private UserDAO dao = DAOFact.getUserDAO();
	
	@Override
	public void addUser(User user) {
		dao.insert(user);
	}

	@Override
	public User check(String login, String password) {
		List<User> users = dao.findByLoginAndPassword(login, password);
		if(users.size()>0) {
			return users.get(0);
		}
		else {
			return null;
		}
	}

}
