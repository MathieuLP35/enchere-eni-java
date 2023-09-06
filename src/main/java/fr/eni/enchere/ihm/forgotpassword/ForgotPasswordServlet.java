package fr.eni.enchere.ihm.forgotpassword;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.security.SecureRandom;
import java.util.Properties;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bll.manager.UtilisateurManager;
import fr.eni.enchere.bll.sing.ManagerSing;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private UtilisateurManager manager = ManagerSing.getInstanceUtilisateur();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/user/forgotpassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		Utilisateur utilisateur = manager.checkEmailUser(email);
		
	    if (utilisateur != null) {
	        
	        String nouveauMotDePasse = genererMotDePasseAleatoire();
	        utilisateur.setMotdepasse(nouveauMotDePasse);
	        
	        try {
				manager.update(utilisateur, utilisateur.getNoUtilisateur());
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        request.setAttribute("message", "Votre nouveau mot de passe à bien été envoyer sur votre email. (" + nouveauMotDePasse + ")");
	        
	        // Rediriger l'utilisateur vers une page de confirmation
	        request.getRequestDispatcher("/WEB-INF/user/forgotpassword.jsp").forward(request, response);
	    } else {
	        // L'email n'existe pas dans la base de données, afficher un message d'erreur
	        request.setAttribute("message", "L'email n'existe pas dans notre système.");
	        request.getRequestDispatcher("/WEB-INF/user/forgotpassword.jsp").forward(request, response);
	    }
		request.getRequestDispatcher("/WEB-INF/user/forgotpassword.jsp").forward(request, response);
	}
	
	// Fonction pour générer un mot de passe aléatoire
	private String genererMotDePasseAleatoire() {
	    int longueurMotDePasse = 12;
	    
	    String caracteresPossibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";

	    SecureRandom random = new SecureRandom();
	    StringBuilder motDePasse = new StringBuilder();

	    for (int i = 0; i < longueurMotDePasse; i++) {
	        int index = random.nextInt(caracteresPossibles.length());
	        motDePasse.append(caracteresPossibles.charAt(index));
	    }

	    return motDePasse.toString();
	}

}
