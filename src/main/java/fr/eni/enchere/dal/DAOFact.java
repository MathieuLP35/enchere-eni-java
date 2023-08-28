package fr.eni.enchere.dal;

public class DAOFact {
	public static EnchereDAO getTaskDAO() {
		return new EnchereDAOImpl();
	}
}
