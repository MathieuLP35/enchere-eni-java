package fr.eni.enchere.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.dao.CategorieDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.util.ConnectionProvider;

public class CategorieDAOImpl implements CategorieDAO {
	
	final String SELECT_CATEGORIES = "SELECT no_categorie, libelle FROM CATEGORIES";
	final String SELECT_BY_ID_CATEGORIES = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";
	final String INSERT_CATEGORIES = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	final String GET_CATEGORIE_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie = ?";
	final String UPDATE_CATEGORIES = "UPDATE CATEGORIES SET libelle = ? WHERE no_categorie = ?";
	final String REMOVE_CATEGORIE = "DELETE FROM CATEGORIES WHERE no_categorie = ?";


	
	@Override
	public void insertCategorie(Categorie categorie) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT_CATEGORIES, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getLibelle());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNoCategorie(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertCategorie");
		}
	}
	
	@Override
	public List<Categorie> getAllCategorie() throws DALException {
		List<Categorie> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIES);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorie categorie = new Categorie(rs.getString("libelle"));
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				result.add(categorie);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getAllCategorie");
		}

		return result;
	}
	
	@Override
	public Categorie findByIdCategorie(Integer idCategorie) throws DALException {
		Categorie categorie = new Categorie();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_CATEGORIES);
			stmt.setInt(1, idCategorie);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				categorie = new Categorie(rs.getString("libelle"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_findByIdCategorie");
		}

		return categorie;

	}
	
	@Override
	public void updateCategorie(Categorie categorie, Integer idCat) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE_CATEGORIES);
			stmt.setString(1, categorie.getLibelle());
			stmt.setInt(2, idCat);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public void removeCategorie(Integer idCat) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(REMOVE_CATEGORIE);
			stmt.setInt(1, idCat);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}
	
	@Override
	public Categorie getCategorieById(Integer idCat) throws DALException {
		Categorie categorie = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement stmt = con.prepareStatement(GET_CATEGORIE_BY_ID)) {
			stmt.setInt(1, idCat);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next() && categorie != null) {
					categorie.setNoCategorie(idCat);
				}
			}
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}

		return categorie;
	}
}
