package fr.eni.right.dal;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur user) throws DALException;
	public List<Utilisateur> getAllUsers() throws DALException;
	public List<Utilisateur> findByLoginAndPassword(String login, String password) throws DALException;
	public Utilisateur findByPseudo(String pseudo) throws DALException;
	public Utilisateur findById(Integer idUser) throws DALException;
	public Utilisateur findByEmail(String emailUser) throws DALException;
	public void update(Utilisateur user, Integer noUtilisateur) throws DALException;
}
