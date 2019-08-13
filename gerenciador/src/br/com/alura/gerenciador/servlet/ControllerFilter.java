package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.action.Action;

//@WebFilter("/main") > Config Web.xml
public class ControllerFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) responseServlet;
		HttpServletRequest request = (HttpServletRequest) requestServlet;		
		
		String paramAction = request.getParameter("action");

		String className = "br.com.alura.gerenciador.servlet.action." + paramAction;

		Action action = null;

		try {
			action = (Action) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e.getMessage());
		}

		String paramRequest = action.run(request, response);

		String[] param = paramRequest.split(":");

		if (param[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + param[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(param[1]);
		}
	}

}
