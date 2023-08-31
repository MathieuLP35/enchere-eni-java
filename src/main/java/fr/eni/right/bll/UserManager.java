package fr.eni.right.bll;

import fr.eni.right.bo.User;

public interface UserManager {
	public void addUser(User user);
	public User check(String login, String password);
	public void update(User user, Integer noUtilisateur);
}
