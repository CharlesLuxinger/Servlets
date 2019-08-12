package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.servlet.action.Action;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAction = request.getParameter("action");
		HttpSession session = request.getSession();
		
		boolean userChecked = session.getAttribute("userLogon") == null;
		boolean loginAction = paramAction.equals("LoginForm") || paramAction.equals("Login");

		if (!loginAction && userChecked) {
			response.sendRedirect("main?action=LoginForm");
			return;
		}

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
