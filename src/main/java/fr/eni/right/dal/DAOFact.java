package fr.eni.right.dal;

public class DAOFact {
	public static UtilisateurDAO getUserDAO() {
		return new UtilisateurDAOImpl();
	}
}
