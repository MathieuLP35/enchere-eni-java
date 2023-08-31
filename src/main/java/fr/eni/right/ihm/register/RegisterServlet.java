package fr.eni.right.ihm.register;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import fr.eni.right.bll.BLLException;
import fr.eni.right.bll.UserManager;
import fr.eni.right.bll.UserManagerSing;
import fr.eni.right.bo.User;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerSing.getInstance();
	
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
		} else if (password != confirmPassword) {
			request.setAttribute("message", "Le mot de passe doit être identique au mot de passe de confirmation");
		} else {
			try {
				manager.addUser(new User(
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
					    false // Un nouvel utilisateur ne devrait pas être un administrateur par défaut
					));
				request.setAttribute("message", "Inscription OK");
			} catch (BLLException e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
			}
		}

		request.getRequestDispatcher("/WEB-INF/user/register.jsp").forward(request, response);
	}

}
