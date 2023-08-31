package fr.eni.right.bll;

import java.util.List;

import fr.eni.admin.dal.DALException;
import fr.eni.right.bo.User;

public interface UserManager {
	public void addUser(User user) throws BLLException;
	public User check(String login, String password);
	public User checkUser(String pseudo);
	public User checkIdUser(Integer idUser);
	public List<User> getAllUser();
	public void update(User user, Integer noUtilisateur);
}
