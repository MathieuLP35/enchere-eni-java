package fr.eni.enchere.ihm.register;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bll.manager.UtilisateurManager;
import fr.eni.enchere.bll.sing.UtilisateurManagerSing;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSing.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/user/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("pseudo");
		String password = request.getParameter("motdepasse");
		String confirmPassword = request.getParameter("confirmationMotDePasse");
		
		if (login == null || login.isBlank()) {
			request.setAttribute("message", "Le login doit être rempli");
		} else if (password == null || password.isBlank()) {
			request.setAttribute("message", "Le mot de passe doit être rempli");
		} else if (!password.equals(confirmPassword)) {
			request.setAttribute("message", "Le mot de passe doit être identique au mot de passe de confirmation");
		} else {
			try {
				Utilisateur utilisateur = new Utilisateur(
					    request.getParameter("pseudo"),
					    request.getParameter("prenom"),
					    request.getParameter("nom"),
					    request.getParameter("email"),
					    request.getParameter("telephone"),
					    request.getParameter("rue"),
					    request.getParameter("codePostal"),
					    request.getParameter("ville"),
					    request.getParameter("motdepasse"),
					    0,
					    false, // Un nouvel utilisateur ne devrait pas être un administrateur par défaut
					    true // Un nouvel utilisateur est activer par default. 
				 );
				manager.addUser(utilisateur);
				// On met l'utilisateur en session
	            request.getSession().setAttribute("user", utilisateur);
	            //request.getSession().setMaxInactiveInterval(300);
	            request.getRequestDispatcher("/AccueilServlet").forward(request, response);
	            
			} catch (BLLException e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
			}
		}

		request.getRequestDispatcher("/WEB-INF/user/register.jsp").forward(request, response);
	}

}
