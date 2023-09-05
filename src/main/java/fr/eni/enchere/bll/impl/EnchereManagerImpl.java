package fr.eni.enchere.bll.impl;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.xalan.xsltc.compiler.sym;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.fact.DAOFact;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.exception.DALException;

public class EnchereManagerImpl implements EnchereManager{

	private EnchereDAO dao = DAOFact.getEnchereDAO();

	@Override
	public void addArticle(ArticleVendu articleVendu) throws DALException {
		dao.insertArticleVendu(articleVendu);
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws DALException {
		return dao.getAllArticleVendu();
	}

	@Override
	public void addCategorie(Categorie categorie) throws DALException {
		dao.insertCategorie(categorie);
	}

	@Override
	public List<Categorie> getAllCategorie() throws DALException {
		return dao.getAllCategorie();
	}

	@Override
	public void addEnchere(Enchere enchere) throws DALException {
		dao.insertEnchere(enchere);
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		return dao.getAllEnchere();
	}

	@Override
	public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		dao.insertRetrait(retrait, articleVendu);
	}

	@Override
	public List<Retrait> getAllRetrait() throws DALException {
		return dao.getAllRetrait();
	}

	@Override
	public void updateCategorie(Categorie categorie, Integer idCat) throws DALException {
		dao.updateCategorie(categorie, idCat);
	}

	@Override
	public void removeCategorie(Integer idCat) throws BLLException {
		if(getCategorieById(idCat) != null) {
			throw new BLLException("Cette catégorie contient des articles et ne peut pas être supprimé.");
		} else {
			try {
				dao.removeCategorie(idCat);
			} catch (DALException e) {
				e.printStackTrace();
				throw new BLLException("Cette catégorie contient des articles et ne peut pas être supprimé.");
			}
		}
	}

	@Override
	public Categorie getCategorieById(Integer idCat){
		try {
			return dao.getCategorieById(idCat);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Enchere> getEncheresFilter(Integer idCat, String nomArticle, 
			Boolean enchereOuverteFilter, Boolean enchereEnCoursFilter, Boolean enchereRemporterFilter, 
			Boolean venteEnchereEnCours, Boolean venteEnchereNonDébutées, Boolean venteEnchereTerminées, Integer idUtilisateur) throws DALException {
		return dao.getEncheresFilter(idCat, nomArticle, 
				enchereOuverteFilter, enchereEnCoursFilter, enchereRemporterFilter, 
				venteEnchereEnCours, venteEnchereNonDébutées, venteEnchereTerminées, idUtilisateur);
	}
}
