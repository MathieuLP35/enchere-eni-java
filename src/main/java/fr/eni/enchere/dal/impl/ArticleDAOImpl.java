package fr.eni.enchere.dal.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.dao.ArticleDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.util.ConnectionProvider;

public class ArticleDAOImpl implements ArticleDAO {
	
	final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, lienImg) VALUES (?,?,?,?,?,?,?,?,?)";
	

	final String SELECT_BY_ID_ARTICLES_VENDUS = "SELECT nom_article as nomArticle, description, date_debut_encheres AS dateDebutEnchere, date_fin_encheres AS dateFinEnchere, prix_initial as prixInitial, prix_vente as prixVente, lienImg, no_utilisateur, no_categorie FROM ARTICLES_VENDUS WHERE no_article = ?";

	final String SELECT_ARTICLES_VENDUS = """
			SELECT ARTICLES_VENDUS.no_article, nom_article as nomArticle, description, date_debut_encheres AS dateDebutEnchere, date_fin_encheres AS dateFinEnchere, prix_initial as prixInitial, prix_vente as prixVente, lienImg, UTILISATEURS.*, CATEGORIES.*, RETRAITS.* FROM ARTICLES_VENDUS
		 	INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
		 	INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
		 	INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
		 """;
	final String SELECT_RETRAIT_BY_ARTICLE = "SELECT * FROM RETRAITS WHERE no_article = ?";
	
	final String SELECT_CATEGORIE_BY_ARTICLE = "SELECT * FROM CATEGORIES INNER JOIN ARTICLES_VENDUS ON CATEGORIES.no_categorie = ARTICLES_VENDUS.no_categorie WHERE ARTICLES_VENDUS.no_article = ?";
	final String SELECT_ENCHERES_BY_ID_ARTICLES = "SELECT no_enchere, ENCHERES.no_utilisateur AS idUser, no_article, date_enchere, montant_enchere, UTILISATEURS.* FROM ENCHERES INNER JOIN UTILISATEURS ON UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur WHERE no_article = ?";
	final String SELECT_UTILISATEUR_BY_ARTICLE = "SELECT * FROM UTILISATEURS INNER JOIN ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur WHERE ARTICLES_VENDUS.no_article = ?";
	
	final String GET_ENCHERES_FILTER = """
		    SELECT no_enchere, ENCHERES.no_utilisateur AS idUser, ENCHERES.no_article AS idArticle, date_enchere, montant_enchere,
		    ARTICLES_VENDUS.nom_article AS nomArticle, ARTICLES_VENDUS.prix_vente AS prixVenteArticle, ARTICLES_VENDUS.date_debut_encheres AS dateDebutEnchere, ARTICLES_VENDUS.date_fin_encheres AS dateFinEnchere,
		    UTILISATEURS.nom AS nomUser, UTILISATEURS.prenom AS prenomUser FROM ENCHERES
		    INNER JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur
		    INNER JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article
		    WHERE 1=1
		    %s
	""";
	
	@Override
	public ArticleVendu findByIdArticle(Integer idArticle) throws DALException {

		ArticleVendu articleVendu = new ArticleVendu();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID_ARTICLES_VENDUS);
			stmt.setInt(1, idArticle);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				articleVendu = new ArticleVendu(rs.getString("nomArticle"), rs.getString("description"), rs.getDate("dateDebutEnchere"), rs.getDate("dateFinEnchere"),
						rs.getInt("prixInitial"), rs.getInt("prixVente"), rs.getString("lienImg"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_findByIdArticleVendu");
		}

		return articleVendu;
	}


	@Override
	public void insertArticleVendu(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_ARTICLES_VENDUS, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, articleVendu.getNomArticle());
			stmt.setString(2, articleVendu.getDescription());
			stmt.setDate(3, (java.sql.Date) articleVendu.getDateDebutEnchere());
			stmt.setDate(4, (java.sql.Date) articleVendu.getDateFinEnchere());
			stmt.setInt(5, articleVendu.getPrixInitial());
			stmt.setInt(6, articleVendu.getPrixVente());
			stmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, articleVendu.getCategorie().getNoCategorie());
			stmt.setString(9, articleVendu.getLienImg());
			
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					articleVendu.setNoArticle(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DALException("ms_insertArticleVendu");
		}

	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws DALException {
		List<ArticleVendu> result = new ArrayList<>();

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ARTICLES_VENDUS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu(rs.getString("nomArticle"), rs.getString("description"), rs.getDate("dateDebutEnchere"), rs.getDate("dateFinEnchere"),
						rs.getInt("prixInitial"), rs.getInt("prixVente"), rs.getString("lienImg"));
				articleVendu.setNoArticle(rs.getInt("no_article"));
				articleVendu.setLstEncheres(getAllEnchereByArticle(articleVendu.getNoArticle()));
				articleVendu.setUtilisateur(getUtilisateurByArticle(articleVendu.getNoArticle()));
				articleVendu.setLieuRetrait(getLieuRetraitByArticle(articleVendu.getNoArticle()));
				articleVendu.setCategorie(getCategorieByArticle(articleVendu.getNoArticle()));
				System.out.println(articleVendu.toString());
				result.add(articleVendu);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getAllArticleVendu");
		}

		return result;
	}
	
	private List<Enchere> getAllEnchereByArticle(Integer noArticle) throws DALException {
		List<Enchere> encheres = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ENCHERES_BY_ID_ARTICLES);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Enchere enchere = new Enchere();
				enchere.setNoEnchere(rs.getInt("no_enchere"));
				//enchere.setArticleVendu(findByIdArticle(noArticle));
				enchere.setDateEnchere(rs.getTimestamp("date_enchere").toLocalDateTime());
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setUser(utilisateur);
				enchere.setMontant(rs.getInt("montant_enchere"));
				encheres.add(enchere);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_findEnchereByIdArticle");
		}

		return encheres;
	}
	
	private Retrait getLieuRetraitByArticle(Integer noArticle) throws DALException {
		Retrait retrait = new Retrait();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_RETRAIT_BY_ARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				retrait = new Retrait();
				retrait.setRue(rs.getString("rue"));
				retrait.setCodePostal(rs.getString("code_postal"));
				retrait.setVille(rs.getString("ville"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getLieuRetraitByArticle");
		}

		return retrait;
	}
	private Categorie getCategorieByArticle(Integer noArticle) throws DALException {
		Categorie categorie = new Categorie();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE_BY_ARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				categorie = new Categorie(rs.getString("libelle"));
				categorie.setNoCategorie(rs.getInt("no_categorie"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getCategorieByArticle");
		}

		return categorie;
	}
	private Utilisateur getUtilisateurByArticle(Integer noArticle) throws DALException {
		Utilisateur utilisateur = new Utilisateur();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_UTILISATEUR_BY_ARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DALException("ms_getUtilisateurByArticle");
		}
		System.out.println(utilisateur);
		return utilisateur;
	}
	
	@Override
	public List<ArticleVendu> getArticlesFilter(Integer idCat, String nomArticle, Boolean enchereOuverteFilter, Boolean enchereEnCoursFilter, Boolean enchereRemporterFilter, Boolean venteEnchereEnCours, Boolean venteEnchereNonDébutées, Boolean venteEnchereTerminées, Integer idUtilisateur) throws DALException {
	    List<ArticleVendu> result = new ArrayList<>();

	    try (Connection con = ConnectionProvider.getConnection()) {
	        String whereClause = "";
	        if (idCat != null && idCat != 0) {
	            whereClause += " AND ARTICLES_VENDUS.no_categorie = ?";
	        }
	        if (nomArticle != null && !nomArticle.isEmpty()) {
	            whereClause += " AND ARTICLES_VENDUS.nom_article LIKE ?";
	        }
	        if(enchereOuverteFilter) {
	        	whereClause += " AND CAST(GETDATE() AS DATE) >= CAST(date_debut_encheres AS DATE)\r\n"
	        			+ "AND CAST(GETDATE() AS DATE) <= CAST(date_fin_encheres AS DATE)";
	        }
	        if(enchereEnCoursFilter){
	        	whereClause += " AND CAST(GETDATE() AS DATE) >= CAST(date_debut_encheres AS DATE)\r\n"
	        			+ "AND CAST(GETDATE() AS DATE) <= CAST(date_fin_encheres AS DATE) AND ENCHERES.no_utilisateur = ?";
	        }
	        if(enchereRemporterFilter){
	        	whereClause += " AND CAST(GETDATE() AS DATE) >= CAST(date_fin_encheres AS DATE) AND ARTICLES_VENDUS.no_article IN (SELECT ENCHERES.no_article FROM ENCHERES WHERE date_enchere = (SELECT MAX(date_enchere) FROM ENCHERES) AND ENCHERES.no_utilisateur = ?)";
	        }
	        if (venteEnchereEnCours) {
	            whereClause += " AND ARTICLES_VENDUS.no_utilisateur = ?\r\n"
	                        + "AND CAST(GETDATE() AS DATE) >= CAST(date_debut_encheres AS DATE)\r\n"
	                        + "AND CAST(GETDATE() AS DATE) <= CAST(date_fin_encheres AS DATE)";
	        }
	        if(venteEnchereNonDébutées){
	        	whereClause += " AND CAST(GETDATE() AS DATE) < CAST(date_debut_encheres AS DATE)";
	        }
	        if(venteEnchereTerminées){
	        	whereClause += " AND CAST(GETDATE() AS DATE) >= CAST(date_fin_encheres AS DATE)";
	        }
	        String query = String.format(GET_ENCHERES_FILTER, whereClause);
	        PreparedStatement stmt = con.prepareStatement(query);
	        int paramIndex = 1;

	        if (idCat != null && idCat != 0) {
	            stmt.setInt(paramIndex++, idCat);
	        }
	        if (nomArticle != null && !nomArticle.isEmpty()) {
	            stmt.setString(paramIndex++, "%" + nomArticle + "%");
	        }
	        
	        if(enchereEnCoursFilter){
	        	stmt.setInt(paramIndex++, idUtilisateur);
	        }
	        if(enchereRemporterFilter){
	        	stmt.setInt(paramIndex++, idUtilisateur);
	        }
	        if (venteEnchereEnCours) {
	            stmt.setInt(paramIndex++, idUtilisateur);
	        }
	        
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
				articleVendu.setUtilisateur(user);
				articleVendu.setDateDebutEnchere(Date.valueOf(rs.getString("dateDebutEnchere")));
				articleVendu.setDateFinEnchere(Date.valueOf(rs.getString("dateFinEnchere")));
			
				articleVendu.setLstEncheres(getAllEnchereByArticle(articleVendu.getNoArticle()));
				result.add(articleVendu);
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        throw new DALException("ms_getEncheresFilter");
	    }

	    return result;
	}

}
