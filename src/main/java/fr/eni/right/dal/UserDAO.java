package fr.eni.right.dal;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bo.User;

public interface UserDAO {
	public void insert(User user) throws DALException;
	public List<User> findByLoginAndPassword(String login, String password) throws DALException;
}
