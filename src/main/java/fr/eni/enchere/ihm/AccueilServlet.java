package fr.eni.enchere.ihm;

import java.io.IOException;

import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bll.sing.EnchereSing;
import fr.eni.enchere.ihm.model.AccueilModel;

import java.nio.file.Path;
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
			System.out.println(manager.getAllEnchere());
		} catch (Exception e) {
			e.printStackTrace();
			model.setMessage(e.getMessage());
		}
		System.out.println(model.getLstEncheres());
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
		doGet(request, response);
	}

}
