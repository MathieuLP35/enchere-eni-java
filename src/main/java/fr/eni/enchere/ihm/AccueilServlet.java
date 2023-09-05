package fr.eni.enchere.ihm;

import java.io.IOException;

import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bll.sing.EnchereSing;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.ihm.model.AccueilModel;

import java.nio.file.Path;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.tags.shaded.org.apache.xpath.operations.And;

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
	
	AccueilModel model = new AccueilModel();

    /**
     * Default constructor. 
     */
    public AccueilServlet() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Locale.setDefault(request.getLocale());
		ResourceBundle bundle = ResourceBundle.getBundle("fr.eni.enchere.bundles.message", request.getLocale());
		
		try {
			model.setLstCategories(manager.getAllCategorie());
		} catch (Exception e) {
			model.setMessage(e.getMessage());
		}
		
		try {
			model.setLstEncheres(manager.getAllEnchere());
		} catch (Exception e) {
			e.printStackTrace();
			model.setMessage(e.getMessage());
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomArticle = request.getParameter("nomArticle") != null ? request.getParameter("nomArticle") : "";
		Integer idCat = request.getParameter("categorie") != null ? Integer.parseInt(request.getParameter("categorie")): 0;
		
		Boolean enchereOuverteFilter = request.getParameter("achat1") != null ? true : false;
		Boolean enchereEnCoursFilter = request.getParameter("achat2") != null ? true : false;
		Boolean enchereRemporterFilter = request.getParameter("achat3") != null ? true : false;
		
		Boolean venteEnchereEnCours = request.getParameter("vente1") != null ? true : false;
		Boolean venteEnchereNonDébutées = request.getParameter("vente2") != null ? true : false;
		Boolean venteEnchereTerminées = request.getParameter("vente3") != null ? true : false;
		
		Integer idUtilisateur = 0;
		if(request.getSession().getAttribute("user") != null){
			idUtilisateur = ((Utilisateur) request.getSession().getAttribute("user")).getNoUtilisateur();
		}
		
		try {
			model.setLstCategories(manager.getAllCategorie());
		} catch (Exception e) {
			model.setMessage(e.getMessage());
		}
		
		try {
			model.setLstEncheres(manager.getEncheresFilter(idCat, nomArticle, 
					enchereOuverteFilter, enchereEnCoursFilter, enchereRemporterFilter, 
					venteEnchereEnCours, venteEnchereNonDébutées, venteEnchereTerminées, idUtilisateur));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/home/accueil.jsp").forward(request, response);
	}

}
