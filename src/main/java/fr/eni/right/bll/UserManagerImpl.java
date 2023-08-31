package fr.eni.right.bll;

import java.util.List;

import fr.eni.enchere.dal.DALException;
import fr.eni.right.bll.BLLException;
import fr.eni.right.bo.User;
import fr.eni.right.dal.DAOFact;
import fr.eni.right.dal.UserDAO;

public class UserManagerImpl implements UserManager {
	private UserDAO dao = DAOFact.getUserDAO();
	
	@Override
	public void addUser(User user) throws BLLException {

		if(checkUser(user.getPseudo()) != null) {
			throw new BLLException("Ce pseudo est déjà utilisé.");
		} else {
			try {
				dao.insert(user);
			} catch (DALException e) {
				e.printStackTrace();
			}
		}
	
	}

	@Override
	public User check(String login, String password) {
		List<User> users;
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

	public List<User> getAllUser() {
	    try {
	        return dao.getAllUsers();
	    } catch (DALException e) {
	        // Gérer l'exception, par exemple, imprimer l'erreur
	        e.printStackTrace();
	    }
	    
	    return null;
	}

    @Override

    public User checkUser(String pseudo) {
        User user;
        try {
            user = dao.findByPseudo(pseudo);
            if(user != null) {
                return user;
            }
            else {
                return null;
            }
        } catch (DALException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public void update(User user, Integer noUtilisateur){
		try {
			dao.update(user, noUtilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User checkIdUser(Integer idUser) {
		User user;
		try {
			user = dao.findById(idUser);
			if(user != null) {
				return user;
			}
			else {
				return null;
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(User user, Integer noUtilisateur) {
		try {
			dao.delete(user, noUtilisateur);
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
