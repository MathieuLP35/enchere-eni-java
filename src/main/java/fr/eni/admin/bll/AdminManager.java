package fr.eni.admin.bll;

import java.util.List;

import fr.eni.right.bo.User;

public interface AdminManager {
	public List<User> removeUser(User user);
}
