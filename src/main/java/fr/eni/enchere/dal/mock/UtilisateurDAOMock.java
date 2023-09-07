package fr.eni.enchere.dal.mock;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.dao.UtilisateurDAO;
import fr.eni.enchere.dal.exception.DALException;

public class UtilisateurDAOMock implements UtilisateurDAO {
	private static List<Utilisateur> lst = new ArrayList<>();
	private static Integer cpt=0;
	@Override
	public void insert(Utilisateur user) {
		user.setNoUtilisateur(cpt++);
		lst.add(user);
	}
	@Override
	public List<Utilisateur> findByLoginAndPassword(String login, String password) {
		return lst.stream()
				.filter(u->u.getPseudo().equals(login))
				.filter(u->u.getMotdepasse().equals(password))
				.toList();
	}
	@Override
	public List<Utilisateur> getAllUsers() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utilisateur findByPseudo(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utilisateur findById(Integer idUser) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Utilisateur findByEmail(String emailUser) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Utilisateur user, Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Utilisateur user, Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Integer updateCredit(Integer noUtilisateur, Integer montantACrediter) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
