package fr.eni.right.bll;

import java.util.List;

import fr.eni.right.bo.User;

public interface UserManager {
	public void addUser(User user);
	public User check(String login, String password);
	public List<User> getAllUser();
}
