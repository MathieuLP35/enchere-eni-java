package fr.eni.right.dal;

import java.util.List;

import fr.eni.right.bo.User;

public interface UserDAO {
	public void insert(User user);
	public List<User> findByLoginAndPassword(String login, String password);
}
