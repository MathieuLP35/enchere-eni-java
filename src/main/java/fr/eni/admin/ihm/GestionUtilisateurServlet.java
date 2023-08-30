package fr.eni.admin.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.right.bll.UserManager;
import fr.eni.right.bll.UserManagerSing;
import fr.eni.right.bo.User;

/**
 * Servlet implementation class GestionUtilisateurServlet
 */
public class GestionUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUtilisateurServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isAdmin = ((User) request.getSession().getAttribute("user")).getAdministrateur();
		if (isAdmin) {
			request.setAttribute("users", manager.getAllUser());
			request.getRequestDispatcher("/WEB-INF/admin/gestionUtilisateur.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean isAdmin = ((User) request.getSession().getAttribute("user")).getAdministrateur();
		if (isAdmin) {
			request.getRequestDispatcher("/WEB-INF/admin/gestionUtilisateur.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
		}
	}

}
