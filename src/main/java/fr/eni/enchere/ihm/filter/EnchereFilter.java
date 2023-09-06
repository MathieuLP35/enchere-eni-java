package fr.eni.enchere.ihm.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EnchereFilter
 */
public class EnchereFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public EnchereFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String url = httpRequest.getServletPath(); //url utilisée pour faire la requête
		System.out.println(url);
		
		HttpSession session = httpRequest.getSession();
		
		///si un Utilisateur est présent dans la session ou si on va vers la page de connexion
		if(session.getAttribute("user") != null || url.equals("/LoginServlet") || url.equals("/AccueilServlet") || url.equals("/RegisterServlet") || url.equals("/ForgotPasswordServlet")) {
			//on laisse filer
			chain.doFilter(request, response);
		} else {
			//sinon, on redirige vers la page de connexion
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("LoginServlet");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
