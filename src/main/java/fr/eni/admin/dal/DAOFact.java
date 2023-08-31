package fr.eni.admin.dal;

public class DAOFact {
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImpl();
	}
}
