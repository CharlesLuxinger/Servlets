package br.com.alura.gerenciador.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.model.DB;
import br.com.alura.gerenciador.servlet.model.entity.Empresa;

public class ShowEmpresa extends HttpServlet implements Action{
	private static final long serialVersionUID = 1L;

	public String run(HttpServletRequest request, HttpServletResponse response)
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

		return "forward:formEditEmpresa.jsp";
	}

}
