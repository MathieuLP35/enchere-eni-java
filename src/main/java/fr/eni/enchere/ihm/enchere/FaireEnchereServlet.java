package fr.eni.enchere.ihm.enchere;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import fr.eni.enchere.bll.manager.ArticleManager;
import fr.eni.enchere.bll.sing.ManagerSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.exception.DALException;

/**
 * Servlet implementation class FaireEnchereServlet
 */
public class FaireEnchereServlet extends HttpServlet {
	private ArticleManager managerArticle = ManagerSing.getInstanceArticle();

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
			articleVendu = managerArticle.findByIdArticleVendu(productId);
			System.out.println(articleVendu);
			request.setAttribute("idArticle", articleVendu.getNoArticle());
			request.setAttribute("nomArticle", articleVendu.getNomArticle());
			request.setAttribute("description", articleVendu.getDescription());
			request.setAttribute("categorie", articleVendu.getCategorie().getLibelle());
			request.setAttribute("prixVente", articleVendu.getPrixVente());
			request.setAttribute("prixInitial", articleVendu.getPrixInitial());
			request.setAttribute("debutEnchere", articleVendu.getDateDebutEnchere());
			request.setAttribute("finEnchere", articleVendu.getDateFinEnchere());
			request.setAttribute("lieuRetraitRue", articleVendu.getLieuRetrait().getRue());
			request.setAttribute("lieuRetraitCP", articleVendu.getLieuRetrait().getCodePostal());
			request.setAttribute("lieuRetraitVille", articleVendu.getLieuRetrait().getVille());
			request.setAttribute("utilisateur", articleVendu.getUtilisateur());
			request.setAttribute("utilisateur", articleVendu.getUtilisateur().getNoUtilisateur());
			
			
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
		
		int prixInitial = Integer.parseInt(request.getParameter("prixVente"));
		//System.out.println(request.getParameter("idArticle"));
		LocalDateTime dateActuelle = LocalDateTime.now();

		Integer montant = Integer.parseInt(request.getParameter("montant"));
		
		System.out.println(request.getParameter("idArticle"));
		
		Utilisateur utilisateur = ((Utilisateur) request.getSession().getAttribute("user"));
		System.out.println(utilisateur);
		ArticleVendu articleVendu = new ArticleVendu();
		articleVendu.setNoArticle(Integer.parseInt(request.getParameter("idArticle")));

		Enchere enchere = new Enchere(
			dateActuelle,
			montant,
			utilisateur,
			articleVendu
		   );
		
       
		System.out.println(articleVendu + "ddqzd");
		System.out.println(enchere);
		if(prixInitial < montant) {
			if(montant <= utilisateur.getCredit()) {
				managerArticle.insertPrixArticleVendu(enchere, montant);
				managerArticle.updateMontantArticleVendu(articleVendu, montant);
				/** si une enchere existe **/
				/** du coup update credit **/
				/** update Credit **/
			} else {
				request.setAttribute("message", "Tu n'as pas assez de crédit sur ton compte");
				System.out.println("Tu n'as pas assez de crédit sur ton compte");
			}
		}else {
			request.setAttribute("message", "Tu dois renseigner une valeur supérieur au prix de vente");
			System.out.println("Tu dois renseigner une valeur supérieur au prix de vente");
		}
		
		try {
			articleVendu = managerArticle.findByIdArticleVendu(articleVendu.getNoArticle());
			System.out.println(articleVendu);
			request.setAttribute("idArticle", articleVendu.getNoArticle());
			request.setAttribute("nomArticle", articleVendu.getNomArticle());
			request.setAttribute("description", articleVendu.getDescription());
			request.setAttribute("categorie", articleVendu.getCategorie());
			request.setAttribute("prixVente", articleVendu.getPrixVente());
			request.setAttribute("prixInitial", articleVendu.getPrixInitial());
			request.setAttribute("debutEnchere", articleVendu.getDateDebutEnchere());
			request.setAttribute("finEnchere", articleVendu.getDateFinEnchere());
			request.setAttribute("lieuRetraitRue", articleVendu.getLieuRetrait().getRue());
			request.setAttribute("lieuRetraitCP", articleVendu.getLieuRetrait().getCodePostal());
			request.setAttribute("lieuRetraitVille", articleVendu.getLieuRetrait().getVille());
			request.setAttribute("utilisateur", articleVendu.getUtilisateur());
			request.setAttribute("utilisateur", articleVendu.getUtilisateur().getNoUtilisateur());
			
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/enchere/creation.jsp").forward(request, response);

	}
}
