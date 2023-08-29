package fr.eni.enchere.bll;

public class EnchereSing {
	private static EnchereManager instance;
	public static EnchereManager getInstance() {
		if(instance==null) {
			instance=new EnchereManagerImpl();
		}
		return instance;
	}
}
