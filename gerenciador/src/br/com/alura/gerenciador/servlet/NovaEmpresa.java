package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		Date dataAbertura;

		String nomeEmpresa = request.getParameter("nome");
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(request.getParameter("data"));

		} catch (ParseException e) {
			throw new ServerException(e.getMessage());
		}

		Empresa empresa = new Empresa(null, nomeEmpresa, dataAbertura);

		DB banco = new DB();
		banco.addDb(empresa);

		response.sendRedirect("listaEmpresas");
		
		// Request JSP
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		 * request.setAttribute("nomeEmpresa", empresa.getNome()); 
		 * rd.forward(request, response);
		 */

	}

}
