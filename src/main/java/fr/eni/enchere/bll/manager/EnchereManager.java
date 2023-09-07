package fr.eni.enchere.bll.manager;

import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.exception.DALException;

public interface EnchereManager {

	public void addEnchere(Enchere enchere) throws DALException;
	public List<Enchere> getAllEnchere() throws DALException;
    public Enchere getMontantByEnchere(Integer noArticle) throws DALException; // Ajout de la méthode
}