package fr.eni.right.ihm;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import fr.eni.right.bo.Utilisateur;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns = {"/"})
public class LoginFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Utilisateur user = (Utilisateur) ((HttpServletRequest) request).getSession().getAttribute("user");
		if (user == null) {
			String urlPattern = ((HttpServletRequest) request).getServletPath();
			((HttpServletRequest) request).getSession().setAttribute("urlPattern", urlPattern);
			request.getRequestDispatcher("/LoginServlet").forward(request, response);
		} else {
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);	
			//chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
