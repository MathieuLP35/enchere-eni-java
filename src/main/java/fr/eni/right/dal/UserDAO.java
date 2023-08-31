package fr.eni.right.dal;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bo.User;

public interface UserDAO {
	public void insert(User user) throws DALException;
	public List<User> getAllUsers() throws DALException;
	public List<User> findByLoginAndPassword(String login, String password) throws DALException;
	public User findByPseudo(String pseudo) throws DALException;
	public User findById(Integer idUser) throws DALException;
    public void update(User user, Integer noUtilisateur) throws DALException;
	public void delete(User user,  Integer noUtilisateur) throws DALException;
}
