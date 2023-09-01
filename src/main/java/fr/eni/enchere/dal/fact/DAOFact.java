package fr.eni.enchere.dal.fact;

import fr.eni.enchere.dal.dao.AdminDAO;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.dao.UtilisateurDAO;
import fr.eni.enchere.dal.impl.AdminDAOImpl;
import fr.eni.enchere.dal.impl.EnchereDAOImpl;
import fr.eni.enchere.dal.impl.UtilisateurDAOImpl;

public class DAOFact {
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImpl();
	}
	public static UtilisateurDAO getUserDAO() {
		return new UtilisateurDAOImpl();
	}
}
