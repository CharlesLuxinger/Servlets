package br.com.alura.gerenciador.servlet.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.model.DB;
import br.com.alura.gerenciador.servlet.model.entity.Empresa;

public class AddEmpresa extends HttpServlet implements Action{

	private static final long serialVersionUID = 1L;

	public String run(HttpServletRequest request, HttpServletResponse response)
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

		return "redirect:main?action=ListEmpresa";

		// Request JSP
		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		 * request.setAttribute("nomeEmpresa", empresa.getNome()); rd.forward(request,
		 * response);
		 */

	}

}
