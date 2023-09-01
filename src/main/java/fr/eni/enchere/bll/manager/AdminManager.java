package fr.eni.enchere.bll.manager;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public interface AdminManager {
	public void removeUser(Integer idUser);
	public void desactivateUser(Integer idUser);
}
