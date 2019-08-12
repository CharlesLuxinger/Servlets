package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.entity.Empresa;
import br.com.alura.gerenciador.servlet.persistence.DB;

@WebServlet("/showEmpresa")
public class MostraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));

		DB banco = new DB();
		Empresa empresa;
		try {
			empresa = banco.findById(id);
		} catch (IllegalAccessException e) {
			throw new ServletException(e.getMessage());
		}

		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formEditEmpresa.jsp");
		rd.forward(request, response);
		
		
	}

}
