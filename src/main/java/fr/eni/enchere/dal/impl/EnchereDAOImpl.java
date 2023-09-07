package fr.eni.enchere.dal.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.util.ConnectionProvider;

public class EnchereDAOImpl implements EnchereDAO {

	
	final String SELECT_ENCHERES = """
				SELECT no_enchere, ENCHERES.no_utilisateur AS idUser, ENCHERES.no_article AS idArticle, date_enchere, montant_enchere,
				ARTICLES_VENDUS.nom_article AS nomArticle, ARTICLES_VENDUS.prix_vente AS prixVenteArticle, ARTICLES_VENDUS.date_debut_encheres AS dateDebutEnchere, ARTICLES_VENDUS.date_fin_encheres AS dateFinEnchere,
				UTILISATEURS.nom AS nomUser, UTILISATEURS.prenom AS prenomUser FROM ENCHERES
				INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur
				INNER JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article
			""";
	
	
	final String INSERT_ENCHERES = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?,?,?)";
	
	final String SELECT_HIGHEST_ENCHERES_BY_ID = "SELECT ENCHERES.no_utilisateur, ENCHERES.montant_enchere, ENCHERES.no_article, ENCHERES.date_enchere, UTILISATEURS.* FROM ENCHERES INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur WHERE no_article = ? AND ENCHERES.montant_enchere = (SELECT MAX(montant_enchere) FROM ENCHERES WHERE ENCHERES.no_article = ?) ORDER BY montant_enchere DESC";


	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT_ENCHERES, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, enchere.getUser().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			stmt.setTimestamp(3, Timestamp.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontant());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					enchere.setNoEnchere(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertEnchere");
		}
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		List<Enchere> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ENCHERES);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateur user = new Utilisateur();
				user.setNoUtilisateur(rs.getInt("idUser"));
				user.setNom(rs.getString("nomUser"));
				user.setPrenom(rs.getString("prenomUser"));
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setNoArticle(rs.getInt("idArticle"));
				articleVendu.setNomArticle(rs.getString("nomArticle"));
				articleVendu.setPrixVente(rs.getInt("prixVenteArticle"));
				articleVendu.setDateDebutEnchere(Date.valueOf(rs.getString("dateDebutEnchere")));
				articleVendu.setDateFinEnchere(Date.valueOf(rs.getString("dateFinEnchere")));
				Enchere enchere = new Enchere(rs.getTimestamp("date_enchere").toLocalDateTime(),
						rs.getInt("montant_enchere"), user, articleVendu);
				enchere.setNoEnchere(rs.getInt("no_enchere"));
				result.add(enchere);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getAllEnchere");
		}

		return result;
	}

	public Enchere getMontantByEnchere(Integer noArticle) throws DALException {
	    Enchere result = new Enchere();


	    try (Connection con = ConnectionProvider.getConnection()) {
	        PreparedStatement stmt = con.prepareStatement(SELECT_HIGHEST_ENCHERES_BY_ID);
	        stmt.setInt(1, noArticle);
	        stmt.setInt(2, noArticle);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            result = new Enchere();
	            result.setMontant(rs.getInt("montant_enchere"));
	            Utilisateur user = new Utilisateur();
	            user.setNoUtilisateur(rs.getInt("no_utilisateur"));
	            user.setCredit(rs.getInt("credit"));
	            result.setUser(user);
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new DALException("ms_getMontantByEnchere");
	    }

	    return result;
	}
}
