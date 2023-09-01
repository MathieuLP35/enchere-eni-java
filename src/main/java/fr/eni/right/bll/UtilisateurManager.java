package fr.eni.right.bll;

import java.util.List;

import fr.eni.admin.dal.DALException;
import fr.eni.right.bo.Utilisateur;

public interface UtilisateurManager {
	public void addUser(Utilisateur user) throws BLLException;
	public Utilisateur check(String login, String password);
	public Utilisateur checkUser(String pseudo);
	public Utilisateur checkIdUser(Integer idUser);
	public Utilisateur checkEmailUser(String emailUser);
	public List<Utilisateur> getAllUser();
	public void update(Utilisateur user, Integer noUtilisateur);
	public void delete(Utilisateur user, Integer noUtilisateur);
}
