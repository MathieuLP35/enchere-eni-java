package fr.eni.enchere.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bll.sing.EnchereSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;

import fr.eni.enchere.dal.exception.DALException;

/**
 * Servlet implementation class FaireEnchereServlet
 */
public class FaireEnchereServlet extends HttpServlet {
	private EnchereManager manager = EnchereSing.getInstance();

	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaireEnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
	    //String description = manager.getDescription();
        //String productId = request.getParameter("id");
        //int productId = Integer.parseInt("id");
        int productId = Integer.parseInt(request.getParameter("id"));
        ArticleVendu articleVendu = null;
        try {
			articleVendu = manager.findByIdArticleVendu(productId);
			System.out.println(articleVendu);
			request.setAttribute("idArticle", articleVendu.getNoArticle());
			request.setAttribute("nomArticle", articleVendu.getNomArticle());
			request.setAttribute("description", articleVendu.getDescription());
			request.setAttribute("categorie", articleVendu.getCategorie());
			request.setAttribute("prixVente", articleVendu.getPrixVente());
			request.setAttribute("prixInitial", articleVendu.getPrixInitial());
			request.setAttribute("debutEnchere", articleVendu.getDateDebutEnchere());
			request.setAttribute("finEnchere", articleVendu.getDateFinEnchere());
//			request.setAttribute("lieuRetraitRue", articleVendu.getLieuRetrait().getRue());
//			request.setAttribute("lieuRetraitCP", articleVendu.getLieuRetrait().getCodePostal());
//			request.setAttribute("lieuRetraitVille", articleVendu.getLieuRetrait().getVille());
			request.setAttribute("utilisateur", articleVendu.getUtilisateur());
			System.out.println(articleVendu.getUtilisateur().getNoUtilisateur());
			
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		System.out.println("&&&&&&&&&&&");

		request.getRequestDispatcher("/WEB-INF/enchere/creation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		
		if(request.getParameter("BTN_SAVE")!=null) {
				try {
					doSave(request, response);
				} catch (ServletException | IOException | DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	protected void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DALException {
		System.out.println("qdqzdqzd");
		
		//System.out.println(request.getParameter("idArticle"));
		
/*		Enchere enchere = new Enchere(
				
		        request.getParameter("montant"),
		        request.getParameter("idArticle"),
		        request.getParameter("montant"),
		        
				
				
				
				);
		
		enchere.getNoEnchere();
		

		manager.insertPrixArticleVendu(enchere, montant);

		System.out.println(manager.insertPrixArticleVendu(enchere, montant));
		*/
		
//		int productId = Integer.parseInt(request.getParameter("id"));
//        ArticleVendu articleVendu = manager.findByIdArticleVendu(productId);
//        
//        Enchere enchere = new Enchere();
//        
//	    Integer encherir = Integer.parseInt(request.getParameter("encherir"));
//	   
//	    System.out.println(encherir);
//		try {
//			manager.insertPrixArticleVendu(null, encherir);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("erreur faite maison");
//		}
//		doGet(request, response);

	}
}
