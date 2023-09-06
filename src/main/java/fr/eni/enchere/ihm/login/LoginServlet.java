package fr.eni.enchere.ihm.login;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import fr.eni.enchere.bll.manager.UtilisateurManager;
import fr.eni.enchere.bll.sing.ManagerSing;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurManager manager = ManagerSing.getInstanceUtilisateur();
    

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Locale.setDefault(request.getLocale());
		//ResourceBundle bundle = ResourceBundle.getBundle("fr.eni.enchere.bundles.message", request.getLocale());
    	
        request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("pseudo");
        String password = request.getParameter("motdepasse");
        
        Utilisateur user = manager.check(login, password);
        
        if(user == null) {
            request.setAttribute("message", "Le login ou le mot de passe est incorrect");
            request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
        }
        else {
        	if(request.getParameter("rememberMe") != null) {
        		Cookie rememberMeCookie = new Cookie("rememberMe", String.valueOf(user.getNoUtilisateur()));
        		rememberMeCookie.setMaxAge(30*24*60*60);
        		response.addCookie(rememberMeCookie);
        	}
            // On met l'utilisateur en session
            request.getSession().setAttribute("user", user);
            
            //request.getSession().setMaxInactiveInterval(300);
            request.getRequestDispatcher("/AccueilServlet").forward(request, response);
        }
        
    }
}

