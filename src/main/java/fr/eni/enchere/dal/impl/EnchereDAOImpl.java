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
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.dao.EnchereDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.util.ConnectionProvider;


public class EnchereDAOImpl implements EnchereDAO {
	
	
	// SELECT
	
	final String SELECT_CATEGORIES = "SELECT no_categorie, libelle FROM CATEGORIES";
	
	final String SELECT_RETRAITS = "SELECT no_article, rue, code_postal, ville FROM RETRAITS";
	
	final String SELECT_ARTICLES_VENDUS = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ARTICLES_VENDUS";
	
	final String SELECT_ENCHERES = """ 
			SELECT no_enchere, ENCHERES.no_utilisateur AS idUser, ENCHERES.no_article AS idArticle, date_enchere, montant_enchere, 
			ARTICLES_VENDUS.nom_article AS nomArticle, ARTICLES_VENDUS.prix_vente AS prixVenteArticle, ARTICLES_VENDUS.date_fin_encheres AS dateFinEnchere,
			UTILISATEURS.nom AS nomUser, UTILISATEURS.prenom AS prenomUser FROM ENCHERES
			INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur 
			INNER JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article
		""";
	
	// SELECT BY ID
	
	final String SELECT_BY_ID_ARTICLES_VENDUS = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ARTICLES_VENDUS WHERE no_article = ?";
	
	final String SELECT_BY_ID_CATEGORIES = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";
	
	final String SELECT_BY_ID_RETRAITS = "SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article = ?";
	
	// INSERT
	
	final String INSERT_CATEGORIES = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	
	final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	
	final String INSERT_RETRAITS = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?)";
	
	final String INSERT_ENCHERES = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?,?,?)";
	

	@Override
	public void insertArticleVendu(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_CATEGORIES, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, articleVendu.getNomArticle());
			stmt.setString(2, articleVendu.getDescription());
			stmt.setDate(3, (java.sql.Date) articleVendu.getDateDebutEnchere());
			stmt.setDate(4, (java.sql.Date) articleVendu.getDateFinEnchere());
			stmt.setInt(5, articleVendu.getPrixInitial());
			stmt.setInt(6, articleVendu.getPrixVente());
			stmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, articleVendu.getCategorie().getNoCategorie());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					articleVendu.setNoArticle(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertArticleVendu");
		}
		
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws DALException {
		List<ArticleVendu> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ARTICLES_VENDUS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu(rs.getString("nomArticle"), rs.getString("description"), rs.getDate("dateDebutEnchere"), rs.getDate("dateFinEnchere"),
						rs.getInt("prixInitial"), rs.getInt("prixVente"));
				result.add(articleVendu);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertArticlesVendus");
		}
		
		return result;
	}
	
	@Override
	public ArticleVendu findByIdArticle(Integer idArticle) throws DALException {
		
		ArticleVendu articleVendu = new ArticleVendu();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_ARTICLES_VENDUS);
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				articleVendu = new ArticleVendu(rs.getString("nomArticle"), rs.getString("description"), rs.getDate("dateDebutEnchere"), rs.getDate("dateFinEnchere"),
						rs.getInt("prixInitial"), rs.getInt("prixVente"));
			 // TODO 
			
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_findByIdArticleVendu");
		}
		
		return articleVendu;
	}

	@Override
	public void insertCategorie(Categorie categorie) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_CATEGORIES, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getLibelle());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					categorie.setNoCategorie(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertCategorie");
		}
	}

	@Override
	public List<Categorie> getAllCategorie() throws DALException {
		List<Categorie> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIES);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Categorie categorie = new Categorie(rs.getString("libelle"));
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				result.add(categorie);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getAllCategorie");
		}
		
		return result;
	}

	@Override
	public void insertRetrait(Retrait retrait, ArticleVendu article) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_RETRAITS);
			stmt.setInt(1, article.getNoArticle());
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCodePostal());
			stmt.setString(4, retrait.getVille());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertRetrait");
		}
		
	}

	@Override
	public List<Retrait> getAllRetrait() throws DALException {
		List<Retrait> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_RETRAITS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Retrait retrait = new Retrait(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
		
				result.add(retrait);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getAllRetrait");
		}
		
		return result;
	}

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_ENCHERES, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, enchere.getUser().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			stmt.setTimestamp(3, Timestamp.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontant());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					enchere.setNoEnchere(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_insertEnchere");
		}
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		List<Enchere> result = new ArrayList<>();
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ENCHERES);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Utilisateur user = new Utilisateur();
				user.setNoUtilisateur(rs.getInt("idUser"));
				user.setNom(rs.getString("nomUser"));
				user.setPrenom(rs.getString("prenomUser"));
				ArticleVendu articleVendu = new ArticleVendu(); 
				articleVendu.setNoArticle(rs.getInt("idArticle"));
				articleVendu.setNomArticle(rs.getString("nomArticle"));	
				articleVendu.setPrixVente(rs.getInt("prixVenteArticle"));
				articleVendu.setDateFinEnchere(Date.valueOf(rs.getString("dateFinEnchere")));
				Enchere enchere = new Enchere(rs.getTimestamp("date_enchere").toLocalDateTime(), rs.getInt("montant_enchere"), user, articleVendu);
				enchere.setNoEnchere(rs.getInt("no_enchere"));
				result.add(enchere);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getAllEnchere");
		}
		
		return result;
	}

	@Override
	public Categorie findByIdCategorie(Integer idCategorie) throws DALException {
		Categorie categorie = new Categorie();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_CATEGORIES);
			stmt.setInt(1, idCategorie);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				categorie = new Categorie(rs.getString("libelle"));
			
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_findByIdCategorie");
		}
		
		return categorie;

	}

	@Override
	public Retrait findByIdRetrait(Integer idArticle) throws DALException {
		Retrait retrait = new Retrait();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_RETRAITS);
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				retrait = new Retrait(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
			
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_findByIdRetrait");
		}
		
		return retrait;
	}

	
	
}
