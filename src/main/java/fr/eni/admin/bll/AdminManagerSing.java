package fr.eni.admin.bll;

public class AdminManagerSing {
	private static AdminManager instance;
	public static AdminManager getInstance() {
		if(instance==null) {
			instance = new AdminManagerImpl();
		}
		return instance;
	}
}
