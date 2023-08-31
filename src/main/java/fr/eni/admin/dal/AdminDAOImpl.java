package fr.eni.admin.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.util.ConnectionProvider;
import fr.eni.right.bo.User;


public class AdminDAOImpl implements AdminDAO {

	final String REMOVE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	@Override
	public void removeUser(Integer idUser) throws DALException {
	    
	    try (Connection con = ConnectionProvider.getConnection();
	        PreparedStatement stmt = con.prepareStatement(REMOVE_USER)) {
	        stmt.setInt(1, idUser);
	        int rowsAffected = stmt.executeUpdate();
	        
	        if (rowsAffected == 0) {
	            throw new DALException("User with ID " + idUser + " not found.");
	        }
	    } catch (SQLException e) {
	        throw new DALException(e.getMessage());
	    }
	    
	}


	@Override
	public List<User> desactivateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
