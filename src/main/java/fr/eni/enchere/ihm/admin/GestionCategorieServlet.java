package fr.eni.enchere.ihm.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.apache.catalina.Manager;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bll.manager.AdminManager;
import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bll.manager.UtilisateurManager;
import fr.eni.enchere.bll.sing.AdminManagerSing;
import fr.eni.enchere.bll.sing.EnchereSing;
import fr.eni.enchere.bll.sing.UtilisateurManagerSing;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;

/**
 * Servlet implementation class GestionCategorieServlet
 */
public class GestionCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager managerEnchere = EnchereSing.getInstance();
	private UtilisateurManager managerUtilisateur = UtilisateurManagerSing.getInstance();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCategorieServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isAdmin = ((Utilisateur) request.getSession().getAttribute("user")).getAdministrateur();
		if (isAdmin) {
			try {
				System.out.println(managerEnchere.getAllCategorie());
				request.setAttribute("categories", managerEnchere.getAllCategorie());
			} catch (DALException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/admin/gestionCategorie.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isAdmin = ((Utilisateur) request.getSession().getAttribute("user")).getAdministrateur();
		if (isAdmin) {
			if(request.getParameter("BT_ADD") != null) {
				doAdd(request,response);
			}
			if(request.getParameter("BT_EDIT") != null) {
				doEdit(request,response);
			}
			if(request.getParameter("BT_REMOVE") != null) {
				doRemove(request,response);
			}
			try {
				request.setAttribute("categories", managerEnchere.getAllCategorie());
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/admin/gestionCategorie.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
		}
	}
	
	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categorie categorie = new Categorie(request.getParameter("libelleCategorie"));
		try {
			managerEnchere.addCategorie(categorie);
			request.setAttribute("message", "La catégorie " + categorie.getLibelle() + " à été ajouter.");
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/admin/gestionCategorie.jsp").forward(request, response);
	}
	
	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categorie categorie = new Categorie(request.getParameter("libelleCategorie"));
		Integer noCategorie = Integer.parseInt(request.getParameter("idCat"));
		try {
			managerEnchere.updateCategorie(categorie, noCategorie);
			request.setAttribute("message", "La catégorie " + request.getParameter("libelleCategorie") + " à été modifier.");
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer noCategorie = Integer.parseInt(request.getParameter("idCat"));

		try {
			managerEnchere.removeCategorie(noCategorie);
			request.setAttribute("message", "La catégorie " + request.getParameter("libelleCategorie") + " à été supprimer.");
		} catch (BLLException e) {
			request.setAttribute("message", e.getMessage());
			e.printStackTrace();
		}

	}

}
