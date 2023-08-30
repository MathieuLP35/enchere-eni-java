package fr.eni.enchere.ihm;

import java.io.IOException;

import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereSing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereSing.getInstance();

    /**
     * Default constructor. 
     */
    public AccueilServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccueilModel model = new AccueilModel();
		try {
			model.setLstCategories(manager.getAllCategorie());
		} catch (Exception e) {
			model.setMessage(e.getMessage());
		}
		try {
			model.setLstEncheres(manager.getAllEnchere());
		} catch (Exception e) {
			model.setMessage(e.getMessage());
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
	}

}
