package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.entity.Empresa;
import br.com.alura.gerenciador.servlet.persistence.DB;

/**
 * Servlet implementation class ListaEmpresa
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = DB.getEmpresas();
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><body>Empresas Cadastradas:");
		out.println("<ul>");
		empresas.forEach(x -> out.println("<li>" + x.getNome() + "</li>"));
		out.println("</ul>");
		out.println("</body></html>");
	}

}
