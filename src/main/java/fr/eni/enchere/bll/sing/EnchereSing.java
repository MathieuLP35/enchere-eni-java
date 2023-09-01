package fr.eni.enchere.bll.sing;

import fr.eni.enchere.bll.impl.EnchereManagerImpl;
import fr.eni.enchere.bll.manager.EnchereManager;

public class EnchereSing {
	private static EnchereManager instance;
	public static EnchereManager getInstance() {
		if(instance==null) {
			instance=new EnchereManagerImpl();
		}
		return instance;
	}
}
