package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.util.ConnectionProvider;

public class EnchereDAOImpl implements EnchereDAO {

	@Override
	public void insertArticleVendu(ArticleVendu articleVendu) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCategorie(Categorie categorie) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categorie> getAllCategorie() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRetrait(Retrait retrait) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Retrait> getAllRetrait() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
