package fr.eni.right.bll;

public class UserManagerSing {
	private static UserManager instance;
	public static UserManager getInstance() {
		if(instance==null) {
			instance = new UserManagerImpl();
		}
		return instance;
	}
}
