package fr.eni.enchere.dal.dao;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;


public interface EnchereDAO {
	
	public void insertEnchere(Enchere enchere) throws DALException;
	public List<Enchere> getAllEnchere() throws DALException;
	
}
