package fr.eni.enchere.bll.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bll.manager.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.dao.UtilisateurDAO;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.dal.fact.DAOFact;

public class UtilisateurManagerImpl implements UtilisateurManager {
	private UtilisateurDAO dao = DAOFact.getUserDAO();
	
	@Override
	public void addUser(Utilisateur user) throws BLLException {

		String regexTelephone = "[^0-9]";
		Pattern patternTelephone = Pattern.compile(regexTelephone);
		Matcher matcherTelephone = patternTelephone.matcher(user.getTelephone()); 
		
		String regexMail = "^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$";
		Pattern patternMail = Pattern.compile(regexMail);
		Matcher matcherMail = patternMail.matcher(user.getEmail());
		
		if(checkUser(user.getPseudo()) != null) {
			throw new BLLException("Ce pseudo est déjà utilisé.");
		} else if(checkEmailUser(user.getEmail()) != null) {
			throw new BLLException("Cette email est déjà utilisé.");
		} else if(matcherTelephone.find()){
	        throw new BLLException("Le numéro de téléphone n'est pas au format valide. (XXXXXXXXXX)"); 
		} else if(user.getCodePostal().length() < 5 || user.getCodePostal().length() > 5){
			throw new BLLException("Le code postal doit se composé de 5 chiffres."); 
		} else if(matcherMail.find()){
	        throw new BLLException("Le mail n'est pas valide. (xx@xxx.fr)"); 
		} else {
			try {
				dao.insert(user);
			} catch (DALException e) {
				e.printStackTrace();
			}
		}
	
	}

	@Override
	public Utilisateur check(String login, String password) {
		List<Utilisateur> users;
		try {
			users = dao.findByLoginAndPassword(login, password);
			if(users.size()>0) {
				return users.get(0);
			}
			else {
				return null;
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Utilisateur> getAllUser() {
	    try {
	        return dao.getAllUsers();
	    } catch (DALException e) {
	        // Gérer l'exception, par exemple, imprimer l'erreur
	        e.printStackTrace();
	    }
	    
	    return null;
	}

    @Override

    public Utilisateur checkUser(String pseudo) {
        Utilisateur user;
        try {
            user = dao.findByPseudo(pseudo);
            if(user != null) {
                return user;
            }
            else {
                return null;
            }
        } catch (DALException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public void update(Utilisateur user, Integer noUtilisateur){
		try {
			dao.update(user, noUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur checkIdUser(Integer idUser) {
		Utilisateur user;
		try {
			user = dao.findById(idUser);
			if(user != null) {
				return user;
			}
			else {
				return null;
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur checkEmailUser(String emailUser) {
		Utilisateur user;
		try {
			user = dao.findByEmail(emailUser);
			if(user != null) {
				return user;
			}
			else {
				return null;
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(Utilisateur user, Integer noUtilisateur) {
		try {
			dao.delete(user, noUtilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
