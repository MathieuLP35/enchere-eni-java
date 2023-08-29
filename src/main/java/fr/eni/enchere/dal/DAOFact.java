package fr.eni.enchere.dal;

public class DAOFact {
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}
}
