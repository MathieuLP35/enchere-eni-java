package fr.eni.enchere.bll.sing;

import fr.eni.enchere.bll.impl.UtilisateurManagerImpl;
import fr.eni.enchere.bll.manager.UtilisateurManager;

public class UtilisateurManagerSing {
	private static UtilisateurManager instance;
	public static UtilisateurManager getInstance() {
		if(instance==null) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
	}
}
