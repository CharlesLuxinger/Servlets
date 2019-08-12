package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.action.AddEmpresa;
import br.com.alura.gerenciador.servlet.action.AddEmpresaForm;
import br.com.alura.gerenciador.servlet.action.EditEmpresa;
import br.com.alura.gerenciador.servlet.action.ListEmpresa;
import br.com.alura.gerenciador.servlet.action.RemoveEmpresa;
import br.com.alura.gerenciador.servlet.action.ShowEmpresa;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String paramRequest = null;
		switch (action) {
		case "listEmpresas":
			paramRequest = ListEmpresa.run(request, response);
			break;

		case "showEmpresa":
			paramRequest = ShowEmpresa.run(request, response);
			break;

		case "editEmpresa":
			paramRequest = EditEmpresa.run(request, response);
			break;

		case "removeEmpresa":
			paramRequest = RemoveEmpresa.run(request, response);
			break;

		case "addEmpresa":
			paramRequest = AddEmpresa.run(request, response);
			break;
			
		case "addEmpresaForm":
			paramRequest = AddEmpresaForm.run(request, response);
			break;
		default:
			throw new IllegalArgumentException("Ação: " + action + ", Inválida!");
		}

		String[] param = paramRequest.split(":");

		if (param[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + param[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(param[1]);
		}

	}

}
