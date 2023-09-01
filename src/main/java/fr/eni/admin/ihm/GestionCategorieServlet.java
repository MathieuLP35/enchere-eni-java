package fr.eni.admin.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.right.bo.Utilisateur;
import fr.eni.right.dal.UtilisateurDAOImpl;

/**
 * Servlet implementation class GestionCategorieServlet
 */
public class GestionCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
			request.getRequestDispatcher("/WEB-INF/admin/gestionCategorie.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
		}
	}

}
