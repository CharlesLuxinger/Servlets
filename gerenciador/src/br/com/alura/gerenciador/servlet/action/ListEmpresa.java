package br.com.alura.gerenciador.servlet.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.model.DB;
import br.com.alura.gerenciador.servlet.model.entity.Empresa;

public class ListEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void run(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = DB.getEmpresas();

		request.setAttribute("empresas", empresas);
		RequestDispatcher rd = request.getRequestDispatcher("/listEmpresas.jsp");
		rd.forward(request, response);
	}

}
