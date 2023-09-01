package fr.eni.right.ihm.login;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import fr.eni.right.bll.UtilisateurManager;
import fr.eni.right.bll.UtilisateurManagerSing;
import fr.eni.right.bo.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtilisateurManager manager = UtilisateurManagerSing.getInstance();
    

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("pseudo");
        String password = request.getParameter("motdepasse");
        
        Utilisateur user = manager.check(login, password);
        if(user==null) {
            request.setAttribute("message", "utilisteur inconnu");
            request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
        }
        else {
            // On met l'utilisateur en session
            request.getSession().setAttribute("user", user);
            
            //request.getSession().setMaxInactiveInterval(300);
            request.getRequestDispatcher("/AccueilServlet").forward(request, response);
        }
        
    }
}

