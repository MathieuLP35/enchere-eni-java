package fr.eni.enchere.bll.manager;

import java.util.List;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurManager {
	public void addUser(Utilisateur user) throws BLLException;
	public Utilisateur check(String login, String password);
	public Utilisateur checkUser(String pseudo);
	public Utilisateur checkIdUser(Integer idUser);
	public Utilisateur checkEmailUser(String emailUser);
	public List<Utilisateur> getAllUser();
	public void update(Utilisateur user, Integer noUtilisateur) throws BLLException;
	public void delete(Utilisateur user, Integer noUtilisateur);
}
