package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.action.AddEmpresa;
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

		switch (action) {
		case "listEmpresas":
			ListEmpresa.run(request, response);			
			break;
			
		case "showEmpresa":
			ShowEmpresa.run(request, response);	
			break;
			
		case "editEmpresa":
			EditEmpresa.run(request, response);
			break;
			
		case "removeEmpresa":
			RemoveEmpresa.run(request, response);	
			break;
			
		case "addEmpresa":
			AddEmpresa.run(request, response);
			break;
			
		default:
			throw new IllegalArgumentException("Ação: " + action + ", Inválida!");
		}
	}

}
