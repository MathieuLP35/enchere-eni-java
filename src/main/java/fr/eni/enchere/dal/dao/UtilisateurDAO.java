package fr.eni.enchere.dal.dao;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;

public interface UtilisateurDAO {
	public void insert(Utilisateur user) throws DALException;
	public List<Utilisateur> getAllUsers() throws DALException;
	public List<Utilisateur> findByLoginAndPassword(String login, String password) throws DALException;
	public Utilisateur findByPseudo(String pseudo) throws DALException;
	public Utilisateur findById(Integer idUser) throws DALException;
	public Utilisateur findByEmail(String emailUser) throws DALException;
	public void update(Utilisateur user, Integer noUtilisateur) throws DALException;
	void delete(Utilisateur user, Integer noUtilisateur) throws DALException;
	public Integer updateCredit(Integer noUtilisateur, Integer montantACrediter) throws DALException;

}
