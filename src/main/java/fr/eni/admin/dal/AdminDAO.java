package fr.eni.admin.dal;

import java.util.List;

import fr.eni.right.bo.User;


public interface AdminDAO {
	public void removeUser(Integer idUser) throws DALException;
	public void desactivateUser(Integer idUser) throws DALException;
}
