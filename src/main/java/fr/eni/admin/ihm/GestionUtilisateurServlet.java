package fr.eni.admin.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.admin.bll.AdminManager;
import fr.eni.admin.bll.AdminManagerSing;
import fr.eni.right.bll.UtilisateurManager;
import fr.eni.right.bll.UtilisateurManagerSing;
import fr.eni.right.bo.Utilisateur;

/**
 * Servlet implementation class GestionUtilisateurServlet
 */
public class GestionUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSing.getInstance();
	private AdminManager managerAdmin = AdminManagerSing.getInstance();
       
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
		Boolean isAdmin = ((Utilisateur) request.getSession().getAttribute("user")).getAdministrateur();
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
		Boolean isAdmin = ((Utilisateur) request.getSession().getAttribute("user")).getAdministrateur();
		if (isAdmin) {
			if(request.getParameter("BT_DESACTIVATE") != null) {
				doDesactivate(request,response);
			}
			if(request.getParameter("BT_REMOVE") != null) {
				doRemove(request,response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
		}
	}
	
	private void doDesactivate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", manager.getAllUser());
		request.getRequestDispatcher("/WEB-INF/admin/gestionUtilisateur.jsp").forward(request, response);
	}
	
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		managerAdmin.removeUser(Integer.parseInt(request.getParameter("idUser")));
		
		request.setAttribute("message", "L'utilisateur ID:" + request.getParameter("idUser") + "à été supprimé.");
		request.setAttribute("users", manager.getAllUser());
		
		request.getRequestDispatcher("/WEB-INF/admin/gestionUtilisateur.jsp").forward(request, response);
	}

}
