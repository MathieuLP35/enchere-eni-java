package fr.eni.enchere.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.dao.UtilisateurDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.util.ConnectionProvider;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	final String GET_ALL_USERS = "SELECT * FROM UTILISATEURS";
	
	final String INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, activer) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM UTILISATEURS WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?";
	
	final String FIND_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
	
	final String FIND_BY_USER_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	final String FIND_BY_USER_EMAIL = "SELECT * FROM UTILISATEURS WHERE email = ?";

	final String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	final String UPDATE_ALL = "UPDATE UTILISATEURS SET  pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ? WHERE no_utilisateur = ?";

	final String UPDATE_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
	@Override
	public void insert(Utilisateur user) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getPseudo());
			stmt.setString(2, user.getNom());
			stmt.setString(3, user.getPrenom());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getTelephone());
			stmt.setString(6, user.getRue());
			stmt.setString(7, user.getCodePostal());
			stmt.setString(8, user.getVille());
			stmt.setString(9, user.getMotdepasse());
			stmt.setInt(10, user.getCredit());
			stmt.setBoolean(11,user.getAdministrateur()?true:false);
			stmt.setBoolean(12, user.getIsActive()?true:false);
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					user.setNoUtilisateur(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			throw new DALException(e.getMessage());
		}
	}


	@Override
	public List<Utilisateur> findByLoginAndPassword(String identifier, String password) throws DALException {
	    List<Utilisateur> users = new ArrayList<>();

	    try (Connection con = ConnectionProvider.getConnection();
	        PreparedStatement stmt = con.prepareStatement(FIND_BY_LOGIN_AND_PASSWORD)) {
	        stmt.setString(1, identifier);
	        stmt.setString(2, identifier);
	        stmt.setString(3, password);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Utilisateur user = mapUtilisateur(rs);
	                users.add(user);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	    
	    return users;
	}
	
	
	@Override
	public Utilisateur findByPseudo(String pseudo) throws DALException {
	    Utilisateur user = null;
	    
	    try (Connection con = ConnectionProvider.getConnection();
	         PreparedStatement stmt = con.prepareStatement(FIND_BY_PSEUDO)) {
	        stmt.setString(1, pseudo);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                user = mapUtilisateur(rs);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	    
	    return user;
	}



	@Override
	public List<Utilisateur> getAllUsers() throws DALException {
	    List<Utilisateur> users = new ArrayList<>();

	    try (Connection con = ConnectionProvider.getConnection();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(GET_ALL_USERS)) {
	        
	        while (rs.next()) {
	        	Utilisateur user = mapUtilisateur(rs);
	            users.add(user);
	        }
	    } catch (SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	    
	    return users;
	}


	@Override
	public Utilisateur findById(Integer idUser) throws DALException {
		Utilisateur user = null;
	    
	    try (Connection con = ConnectionProvider.getConnection();
	         PreparedStatement stmt = con.prepareStatement(FIND_BY_USER_ID)) {
	        stmt.setInt(1, idUser);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                user = mapUtilisateur(rs);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	    
	    return user;
	}

	@Override
	public Utilisateur findByEmail(String emailUser) throws DALException {
		Utilisateur user = null;
	    
	    try (Connection con = ConnectionProvider.getConnection();
	         PreparedStatement stmt = con.prepareStatement(FIND_BY_USER_EMAIL)) {
	        stmt.setString(1, emailUser);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	            	user = mapUtilisateur(rs);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	    
	    return user;
	}
  
  @Override
  public void update(Utilisateur user, Integer noUtilisateur) throws DALException {
	    try (Connection con = ConnectionProvider.getConnection()){
	        PreparedStatement stmt = con.prepareStatement(UPDATE_ALL);
	        System.out.println(user.getCredit());
	        stmt.setString(1, user.getPseudo());
	        stmt.setString(2, user.getNom());
	        stmt.setString(3, user.getPrenom());
	        stmt.setString(4, user.getEmail());
	        stmt.setString(5, user.getTelephone());
	        stmt.setString(6, user.getRue());
	        stmt.setString(7, user.getCodePostal());
	        stmt.setString(8, user.getVille());
	        stmt.setString(9, user.getMotdepasse());
	        stmt.setInt(10, user.getCredit());
	        stmt.setInt(11, user.getNoUtilisateur());
	        stmt.executeUpdate();
	    }
	    catch(SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	}

	@Override
	public void delete(Utilisateur user, Integer noUtilisateur) throws DALException {
	    try (Connection con = ConnectionProvider.getConnection()){
	        PreparedStatement stmt = con.prepareStatement(DELETE_USER);
	        stmt.setInt(1, user.getNoUtilisateur());
	        stmt.executeUpdate();
	    }
	    catch(SQLException e) {
	        throw new DALException(e.getMessage());
	    }	
	}
	
	private Utilisateur mapUtilisateur(ResultSet rs) throws SQLException {
		Utilisateur user = new Utilisateur();
		user.setNoUtilisateur(rs.getInt("no_utilisateur"));
		user.setPseudo(rs.getString("pseudo"));
		user.setNom(rs.getString("nom"));
		user.setPrenom(rs.getString("prenom"));
		user.setEmail(rs.getString("email"));
		user.setTelephone(rs.getString("telephone"));
		user.setRue(rs.getString("rue"));
		user.setCodePostal(rs.getString("code_postal"));
		user.setVille(rs.getString("ville"));
		user.setMotdepasse(rs.getString("mot_de_passe"));
		user.setCredit(rs.getInt("credit"));
		user.setAdministrateur(rs.getBoolean("administrateur"));
		user.setIsActive(rs.getBoolean("activer"));
		user.setCredit(rs.getInt("credit"));
		return user;
	}

	public Integer updateCredit(Integer noUtilisateur, Integer montantACrediter) throws DALException {
	    try (Connection con = ConnectionProvider.getConnection()) {
	        PreparedStatement stmt = con.prepareStatement(UPDATE_CREDIT);
	        stmt.setInt(1, montantACrediter);
	        stmt.setInt(2, noUtilisateur);  
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	    Utilisateur utilisateur = findById(noUtilisateur);
	    Integer credit = utilisateur.getCredit();
		return credit;
	}

}
