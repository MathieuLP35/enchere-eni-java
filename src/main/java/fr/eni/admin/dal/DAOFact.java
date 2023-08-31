package fr.eni.admin.dal;

public class DAOFact {
	public static AdminDAO getEnchereDAO() {
		return new AdminDAOImpl();
	}
}
