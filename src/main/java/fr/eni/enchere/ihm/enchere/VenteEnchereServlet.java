package fr.eni.enchere.ihm.enchere;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDateTime;

import fr.eni.enchere.bll.manager.EnchereManager;
import fr.eni.enchere.bll.sing.EnchereSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.ihm.model.VenteArticleModel;

/**
 * Servlet implementation class VenteEnchereServlet
 */
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class VenteEnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereSing.getInstance();
	private VenteArticleModel model = new VenteArticleModel();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenteEnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Retrait retraitUserRetrait = new Retrait();
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
		
		retraitUserRetrait.setRue(utilisateur.getRue());
		retraitUserRetrait.setCodePostal(utilisateur.getCodePostal());
		retraitUserRetrait.setVille(utilisateur.getVille());
		
		model.setLieuRetrait(retraitUserRetrait);
		
		try {
			model.setLstCategories(manager.getAllCategorie());
		} catch (Exception e) {
			model.setMessage(e.getMessage());
		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/enchere/vente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
		
		ArticleVendu articleVendu = new ArticleVendu();
		
		String message = "";
		 
		articleVendu.setNomArticle(request.getParameter("nomArticle"));
		articleVendu.setDescription(request.getParameter("description"));
		Categorie categorie = new Categorie();
		categorie.setNoCategorie(Integer.parseInt(request.getParameter("categorie")));
		articleVendu.setCategorie(categorie);
		articleVendu.setDateDebutEnchere(Date.valueOf(request.getParameter("dateDebutEnchere")));
		articleVendu.setDateFinEnchere(Date.valueOf(request.getParameter("dateFinEnchere")));
		Retrait retrait = new Retrait();
		retrait.setRue(request.getParameter("rue"));
		retrait.setCodePostal(request.getParameter("codePostal"));
		retrait.setVille(request.getParameter("ville"));
		articleVendu.setLieuRetrait(retrait);
		articleVendu.setPrixInitial(Integer.parseInt(request.getParameter("miseAPrix")));
		articleVendu.setPrixVente(Integer.parseInt(request.getParameter("miseAPrix")));
		articleVendu.setUtilisateur(utilisateur);
		
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
	    for (Part part : request.getParts()) {
	    	if(utilisateur.getPseudo().equals("axelmdev2")) {
	    		part.write("E:\\projet\\enchere-eni-java\\src\\main\\webapp\\upload\\" +  fileName);
	    	} else if(utilisateur.getPseudo().equals("mathieu")) {
	    		part.write("E:\\ENI\\JAVA\\JAVA EE\\TP\\enchere-eni-java\\src\\main\\webapp\\upload\\" + fileName);
	    	}
	    }
	    
	     
		articleVendu.setLienImg(fileName);
		
		try {
			manager.addArticle(articleVendu);
			model.setMessage("Ajout d'article effectué");
		} catch (Exception e) {
			e.printStackTrace();
			//message = bundle.getString(e.getMessage());
		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/enchere/vente.jsp").forward(request, response);
	}

}
