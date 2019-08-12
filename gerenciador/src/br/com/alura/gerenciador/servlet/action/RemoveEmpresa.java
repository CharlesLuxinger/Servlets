package br.com.alura.gerenciador.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.model.DB;

public class RemoveEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void run(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.valueOf(request.getParameter("id"));

		DB banco = new DB();
		banco.removeEmpresaById(id);
		
		response.sendRedirect("main?action=listEmpresas");
	}
}
