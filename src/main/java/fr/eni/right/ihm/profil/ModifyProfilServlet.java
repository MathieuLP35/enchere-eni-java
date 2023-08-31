package fr.eni.right.ihm.profil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import fr.eni.right.bll.UserManager;
import fr.eni.right.bll.UserManagerSing;
import fr.eni.right.bo.User;

/**
 * Servlet implementation class ModifyProfilServlet
 */
public class ModifyProfilServlet extends HttpServlet {
	private UserManager manager = UserManagerSing.getInstance();
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); // Utilisez false pour éviter de créer une nouvelle session si elle n'existe pas

        if (session != null) {
            // Récupérer l'utilisateur depuis la session
            User user = (User) session.getAttribute("user");

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

		if(request.getParameter("BTN_SAVE")!=null) {
			doSave(request, response);
		}
		else if(request.getParameter("BTN_DELETE")!=null) {
			doDelet(request,response);
		}
	}
	
	private void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession(false);
	    User user = (User) session.getAttribute("user");

	    String pseudo = request.getParameter("pseudo");
	    String prenom = request.getParameter("prenom");
	    String nom = request.getParameter("nom");
	    String email = request.getParameter("email");
	    String telephone = request.getParameter("telephone");
	    String rue = request.getParameter("rue");
	    String ville = request.getParameter("ville");
	    String codePostal = request.getParameter("codePostal");

	    // Mettez à jour les attributs de l'utilisateur avec les nouvelles valeurs
	    if(!pseudo.isBlank()){user.setPseudo(pseudo);}
	    if(!prenom.isBlank()){user.setPrenom(prenom);}
	    if(!nom.isBlank()){user.setNom(nom);}
	    if(!email.isBlank()){user.setEmail(email);}
	    if(!telephone.isBlank()){user.setTelephone(telephone);}
	    if(!rue.isBlank()){user.setRue(rue);}
	    if(!ville.isBlank()){user.setVille(ville);}
	    if(!codePostal.isBlank()){user.setCodePostal(codePostal);}

	        manager.update(user, user.getNoUtilisateur());
	        

			request.getRequestDispatcher("/WEB-INF/home/profil.jsp").forward(request, response);
			
	}
	
	private void doDelet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession(false);
	    User user = (User) session.getAttribute("user");
	    
	    
	    String motDePasse = request.getParameter("motdepasse");

	    if(user.getMotdepasse().equals(motDePasse)) {
        manager.delete(user, user.getNoUtilisateur());
		session.invalidate();
		request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);

	    }else {
			request.setAttribute("motDePasseErreur", "Le mot de passe est incorrect");
			doGet(request,response);
	    }



	}
}
