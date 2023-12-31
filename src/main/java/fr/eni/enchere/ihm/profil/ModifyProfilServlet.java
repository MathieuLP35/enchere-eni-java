package fr.eni.enchere.ihm.profil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.enchere.bll.exception.BLLException;
import fr.eni.enchere.bll.manager.UtilisateurManager;
import fr.eni.enchere.bll.sing.ManagerSing;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ModifyProfilServlet
 */
public class ModifyProfilServlet extends HttpServlet {
	private UtilisateurManager manager = ManagerSing.getInstanceUtilisateur();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession() != null) {
			// Récupérer l'utilisateur depuis la session
			Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

			if (user != null) {
				// Vous pouvez maintenant accéder aux propriétés de l'utilisateur

				request.setAttribute("pseudo", user.getPseudo());
				request.setAttribute("prenom", user.getPrenom());
				request.setAttribute("nom", user.getNom());
				request.setAttribute("email", user.getEmail());
				request.setAttribute("telephone", user.getTelephone());
				request.setAttribute("credit", user.getCredit());
				request.setAttribute("rue", user.getRue());
				request.setAttribute("ville", user.getVille());
				request.setAttribute("codePostal", user.getCodePostal());

			} else {
				// L'utilisateur n'est pas dans la session
				response.getWriter().println("L'utilisateur n'est pas connecté.");
			}
		} else {
			// La session n'existe pas
			response.getWriter().println("Aucune session n'est active.");
			request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);

		}

		request.getRequestDispatcher("/WEB-INF/home/modifyProfil.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("BTN_SAVE") != null) {
			doSave(request, response);
		} else if (request.getParameter("BTN_DELETE") != null) {
			doDelet(request, response);
		}
	}

	private void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String credit = request.getParameter("credit");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String codePostal = request.getParameter("codePostal");
		String motDePasse = request.getParameter("motDePasse");
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");
		
		// le pseudo ne doit contenir que des caractères alphanumériques
		String regexPseudo = "^[a-zA-Z0-9]+$"; // Cette regex accepte uniquement des lettres (majuscules et minuscules) et des chiffres.

		try {
			if ((!nouveauMotDePasse.isBlank() && !confirmationMotDePasse.isBlank())
					|| (nouveauMotDePasse.isBlank() && !confirmationMotDePasse.isBlank())
					|| (!nouveauMotDePasse.isBlank() && confirmationMotDePasse.isBlank())) {
				if (nouveauMotDePasse.equals(confirmationMotDePasse)) {
					if (user.getMotdepasse().equals(motDePasse)) {
						user.setMotdepasse(nouveauMotDePasse);
						System.out.println("Les mots de passe sont bons");
					} else {
						request.setAttribute("motDePasseErreur", "Le mots de passe actuel est incorrect");
						doGet(request, response);
					}
				} else {
					request.setAttribute("motDePasseErreur", "Les mots de passe sont different");
					doGet(request, response);
				}
			}
      
			if (pseudo == null || pseudo.isBlank()) {
			    request.setAttribute("message", "Le login doit être rempli");
			    doGet(request, response);
			} else if (!pseudo.matches(regexPseudo)) {
			    request.setAttribute("message", "Le pseudo ne doit contenir que des caractères alphanumériques");
			    doGet(request, response);
			} else {
				// Mettez à jour les attributs de l'utilisateur avec les nouvelles valeurs
				if (user.getMotdepasse().equals(motDePasse)) {
					user.setPseudo(pseudo);
					user.setPrenom(prenom);
					user.setNom(nom);
					user.setEmail(email);
					user.setCredit(Integer.parseInt(credit));
					user.setTelephone(telephone);
					user.setRue(rue);
					user.setVille(ville);
					user.setCodePostal(codePostal);
					
					// update en base
					manager.update(user, user.getNoUtilisateur());
					// on set la session avec les modifs
					request.getSession().setAttribute("user", user);
				} else {
					request.setAttribute("motDePasseErreur", "Le mots de passe actuel est incorrect");
					doGet(request, response);
				}
			}

		} catch (BLLException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			doGet(request, response);
		}

		request.getRequestDispatcher("/WEB-INF/home/profil.jsp").forward(request, response);
	}

	private void doDelet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

		String motDePasse = request.getParameter("motDePasse");

		if (user.getMotdepasse().equals(motDePasse)) {
			manager.delete(user, user.getNoUtilisateur());
			request.getSession().invalidate();
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("rememberMe") && Integer.parseInt(cookie.getValue()) == user.getNoUtilisateur()) {
						cookie.setMaxAge(0);
					}
				}
			}
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);

		} else {
			request.setAttribute("motDePasseErreur", "Le mot de passe est incorrect");
			doGet(request, response);
		}

	}
}
