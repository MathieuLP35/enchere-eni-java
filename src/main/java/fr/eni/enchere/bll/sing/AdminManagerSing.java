package fr.eni.enchere.bll.sing;

import fr.eni.enchere.bll.impl.AdminManagerImpl;
import fr.eni.enchere.bll.manager.AdminManager;

public class AdminManagerSing {
	private static AdminManager instance;
	public static AdminManager getInstance() {
		if(instance==null) {
			instance = new AdminManagerImpl();
		}
		return instance;
	}
}
