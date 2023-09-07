package fr.eni.enchere.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.enchere.bll.manager.ArticleManager;
import fr.eni.enchere.bll.sing.ManagerSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;

/**
 * Servlet implementation class MesEncheresRemporteesServlet
 */
public class MesEncheresRemporteesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager managerArticleVendu = ManagerSing.getInstanceArticle();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesEncheresRemporteesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
		
		List<ArticleVendu> lstArticlesVendu;
		
		request.setAttribute("utilisateur", utilisateur);
		
		try {
			lstArticlesVendu = managerArticleVendu.getArticlesFilter(null, null, 
					false, false, true, 
					false, false, false, utilisateur.getNoUtilisateur());
			
			request.setAttribute("lstEncheresRemportees", lstArticlesVendu);
			
			if(lstArticlesVendu.size() <= 0) {
				request.setAttribute("message", "Aucune enchère n'a été remporter.");
			}
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/enchere/mesencheresremportees.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/enchere/mesencheresremportees.jsp").forward(request, response);
	}

}
