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

public class EditEmpresa extends HttpServlet implements Action{
	private static final long serialVersionUID = 1L;

	public String run(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DB banco = new DB();
		Empresa editEmpresa;
		Date dataAbertura;
		String nomeEmpresa = request.getParameter("nome");
		Integer id = Integer.valueOf(request.getParameter("id"));

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(request.getParameter("data"));
			
			editEmpresa = banco.findById(id);
		} catch (ParseException|IllegalAccessException e) {
			throw new ServerException(e.getMessage());
		}

		editEmpresa.setNome(nomeEmpresa);
		editEmpresa.setDataAbertura(dataAbertura);
		
		return "redirect:ListEmpresa";
	}

}
