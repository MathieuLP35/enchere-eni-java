package fr.eni.enchere.ihm.profil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/home/profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false); // Utilisez false pour éviter de créer une nouvelle session si elle n'existe pas

        if (session != null) {
            // Récupérer l'utilisateur depuis la session
            Utilisateur user = (Utilisateur) session.getAttribute("user");

            if (user != null) {
                // Vous pouvez maintenant accéder aux propriétés de l'utilisateur

    			request.setAttribute("pseudo", "pseudo");
    			request.setAttribute("prenom", "prenom");
    			request.setAttribute("nom", "nom");
    			request.setAttribute("email", "email");
    			request.setAttribute("telephone", "telephone");
    			request.setAttribute("rue", "rue");
    			request.setAttribute("ville", "ville");
    			request.setAttribute("codePostal", "codePostal");
    			
            } else {
                // L'utilisateur n'est pas dans la session
                response.getWriter().println("L'utilisateur n'est pas connecté.");
            }
        } else {
            // La session n'existe pas
            response.getWriter().println("Aucune session n'est active.");
        }

		request.getRequestDispatcher("/WEB-INF/home/profil.jsp").forward(request, response);

	}

}

