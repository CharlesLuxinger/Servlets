package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/main") > Config Web.xml
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) responseServlet;
		HttpServletRequest request = (HttpServletRequest) requestServlet;
		HttpSession session = request.getSession();
		
		String paramAction = request.getParameter("action");

		boolean userChecked = session.getAttribute("userLogon") == null;
		boolean loginAction = paramAction.equals("LoginForm") || paramAction.equals("Login");

		if (!loginAction && userChecked) {
			response.sendRedirect("main?action=LoginForm");
			return;
		}
		chain.doFilter(request, response);
	}

}
