package fr.eni.enchere.bll.sing;

import fr.eni.enchere.bll.impl.AdminManagerImpl;
import fr.eni.enchere.bll.impl.ArticleManagerImpl;
import fr.eni.enchere.bll.impl.CategorieManagerImpl;
import fr.eni.enchere.bll.impl.EnchereManagerImpl;
import fr.eni.enchere.bll.impl.UtilisateurManagerImpl;
import fr.eni.enchere.bll.manager.AdminManager;
import fr.eni.enchere.bll.manager.ArticleManager;
import fr.eni.enchere.bll.manager.CategorieManager;
import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bll.manager.UtilisateurManager;

public class ManagerSing {
	
	private static AdminManager instanceAdmin;
	
	private static EnchereManager instanceEnchere;
	
	private static ArticleManager instanceArticle;

	private static CategorieManager instanceCategorie;
	
	private static UtilisateurManager instanceUtilisateur;
	
	public static AdminManager getInstanceAdmin() {
		if(instanceAdmin==null) {
			instanceAdmin = new AdminManagerImpl();
		}
		return instanceAdmin;
	}
	
	public static ArticleManager getInstanceArticle() {
		if(instanceArticle==null) {
			instanceArticle=new ArticleManagerImpl();
		}
		return instanceArticle;
	}
	
	public static CategorieManager getInstanceCategorie() {
		if(instanceCategorie==null) {
			instanceCategorie=new CategorieManagerImpl();
		}
		return instanceCategorie;
	}
	
	
	public static EnchereManager getInstanceEnchere() {
		if(instanceEnchere==null) {
			instanceEnchere=new EnchereManagerImpl();
		}
		return instanceEnchere;
	}
	
	
	public static UtilisateurManager getInstanceUtilisateur() {
		if(instanceUtilisateur==null) {
			instanceUtilisateur = new UtilisateurManagerImpl();
		}
		return instanceUtilisateur;
	}
}
