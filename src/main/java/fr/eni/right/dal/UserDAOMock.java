package fr.eni.right.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.right.bo.User;

public class UserDAOMock implements UserDAO {
	private static List<User> lst = new ArrayList<>();
	private static Integer cpt=0;
	@Override
	public void insert(User user) {
		user.setNoUtilisateur(cpt++);
		lst.add(user);
	}
	@Override
	public List<User> findByLoginAndPassword(String login, String password) {
		return lst.stream()
				.filter(u->u.getPseudo().equals(login))
				.filter(u->u.getMotdepasse().equals(password))
				.toList();
	}
	
	
}
