package fr.eni.right.dal;

public class DAOFact {
	public static UserDAO getUserDAO() {
		return new UserDAOMock();
	}
}
