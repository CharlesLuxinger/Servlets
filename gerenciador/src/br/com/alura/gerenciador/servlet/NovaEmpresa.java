package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.entity.Empresa;
import br.com.alura.gerenciador.servlet.persistence.DB;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		
		Empresa empresa = new Empresa(null, nomeEmpresa);
		
		DB banco = new DB();
		banco.addDb(empresa);
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>Empresa " + nomeEmpresa + ", Cadastrada!</body></html>");
	}

}
