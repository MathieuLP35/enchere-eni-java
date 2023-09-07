package fr.eni.enchere.ihm;

import java.io.IOException;
import java.net.CookieStore;

import fr.eni.enchere.bll.manager.ArticleManager;
import fr.eni.enchere.bll.manager.CategorieManager;
import fr.eni.enchere.bll.manager.UtilisateurManager;
import fr.eni.enchere.bll.sing.ManagerSing;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;
import fr.eni.enchere.ihm.model.AccueilModel;

import java.util.Locale;
import java.util.ResourceBundle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieManager managerCategorie = ManagerSing.getInstanceCategorie();
	private ArticleManager managerArticleVendu = ManagerSing.getInstanceArticle();
	private UtilisateurManager managerUtilisateur = ManagerSing.getInstanceUtilisateur();
	
	
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
		
		AccueilModel model = new AccueilModel();

		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && request.getSession().getAttribute("user") != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("rememberMe")) {
					String rememberMeValue = cookie.getValue();
					Utilisateur utilisateur = managerUtilisateur.checkIdUser(Integer.parseInt(rememberMeValue));
					request.getSession().setAttribute("user", utilisateur);
				}
			}
		}
		
		try {
			model.setLstCategories(managerCategorie.getAllCategorie());
		} catch (Exception e) {
			model.setMessage(e.getMessage());
		}
		
		try {
			model.setLstArticlesVendus(managerArticleVendu.getAllArticleVendu());
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
		
		String radioAchats = request.getParameter("achats") != null ? "checked" : "";
		String radioVentes = request.getParameter("ventes") != null ? "checked": "";
		
		Boolean checkboxEnchereOuverteFilter = request.getParameter("achat1") != null ? true : false;
		Boolean checkboxEnchereEnCoursFilter = request.getParameter("achat2") != null ? true : false;
		Boolean checkboxEnchereRemporterFilter = request.getParameter("achat3") != null ? true : false;
		
		String checkboxVenteEnchereEnCours = request.getParameter("vente1") != null ? "checked" : "";
		String checkboxVenteEnchereNonDébutées = request.getParameter("vente2") != null ? "checked" : "";
		String checkboxVenteEnchereTerminées = request.getParameter("vente3") != null ? "checked" : "";
		
		Integer idUtilisateur = 0;
		if(request.getSession().getAttribute("user") != null){
			idUtilisateur = ((Utilisateur) request.getSession().getAttribute("user")).getNoUtilisateur();
		}
		
		try {
			model.setLstCategories(managerCategorie.getAllCategorie());
		} catch (Exception e) {
			model.setMessage(e.getMessage());
		}
		
		try {
			model.setLstArticlesVendus(managerArticleVendu.getArticlesFilter(idCat, nomArticle, 
					enchereOuverteFilter, enchereEnCoursFilter, enchereRemporterFilter, 
					venteEnchereEnCours, venteEnchereNonDébutées, venteEnchereTerminées, idUtilisateur));
			
			request.setAttribute("idCat", idCat);
			request.setAttribute("nomArticle", nomArticle);
			
			request.setAttribute("achats", radioAchats);
			request.setAttribute("achat1", checkboxEnchereOuverteFilter);
			request.setAttribute("achat2", checkboxEnchereEnCoursFilter);
			request.setAttribute("achat3", checkboxEnchereRemporterFilter);
			
			request.setAttribute("ventes", radioVentes);
			request.setAttribute("vente1", checkboxVenteEnchereEnCours);
			request.setAttribute("vente2", checkboxVenteEnchereNonDébutées);
			request.setAttribute("vente3", checkboxVenteEnchereTerminées);
			
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
