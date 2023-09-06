package fr.eni.enchere.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.dao.RetraitDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.util.ConnectionProvider;

public class RetraitDAOImpl implements RetraitDAO {
	

	final String SELECT_RETRAITS = "SELECT no_article, rue, code_postal, ville FROM RETRAITS";

	final String SELECT_BY_ID_RETRAITS = "SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article = ?";

	final String INSERT_RETRAITS = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?)";
	
	
	@Override
	public void insertRetrait(Retrait retrait, ArticleVendu article) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT_RETRAITS);
			stmt.setInt(1, article.getNoArticle());
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCodePostal());
			stmt.setString(4, retrait.getVille());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertRetrait");
		}

	}
	
	
	
	@Override
	public List<Retrait> getAllRetrait() throws DALException {
		List<Retrait> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_RETRAITS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Retrait retrait = new Retrait(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));

				result.add(retrait);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getAllRetrait");
		}

		return result;
	}
	@Override
	public Retrait findByIdRetrait(Integer idArticle) throws DALException {
		Retrait retrait = new Retrait();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_RETRAITS);
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				retrait = new Retrait(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_findByIdRetrait");
		}

		return retrait;
	}
}
