package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.util.ConnectionProvider;

public class EnchereDAOImpl implements EnchereDAO {
	final String SELECT_ALL = "SELECT * FROM Utilisateurs";
	
	final String INSERT = "INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotdepasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setInt(11,utilisateur.getAdministateur()?1:0);
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			throw new DALException("ms_insert");
		}
	}


	@Override
	public List<Utilisateur> getAllUtilisateur() throws DALException {
	    List<Utilisateur> utilisateurs = new ArrayList<>();
	    
	    try (Connection con = ConnectionProvider.getConnection();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
	        
	        while (rs.next()) {
	            Utilisateur utilisateur = new Utilisateur();
	            utilisateur.setNoUtilisateur(rs.getInt("noUtilisateur"));
	            utilisateur.setPseudo(rs.getString("pseudo"));
	            utilisateur.setNom(rs.getString("nom"));
	            utilisateur.setPrenom(rs.getString("prenom"));
	            utilisateur.setEmail(rs.getString("email"));
	            utilisateur.setTelephone(rs.getString("telephone"));
	            utilisateur.setRue(rs.getString("rue"));
	            utilisateur.setCodePostal(rs.getString("code_postal"));
	            utilisateur.setVille(rs.getString("ville"));
	            utilisateur.setMotdepasse(rs.getString("mot_de_passe"));
	            utilisateur.setCredit(rs.getInt("credit"));
	            utilisateur.setAdministateur(rs.getInt("administrateur") == 1);
	            
	            utilisateurs.add(utilisateur);
	        }
	    } catch (SQLException e) {
	        throw new DALException("ms_getAllUtilisateur");
	    }
	    
	    return utilisateurs;
	}
}
