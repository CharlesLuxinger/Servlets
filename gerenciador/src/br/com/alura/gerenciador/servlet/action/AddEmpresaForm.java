package br.com.alura.gerenciador.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpresaForm extends HttpServlet implements Action{

	private static final long serialVersionUID = 1L;

	public String run(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "forward:formAddEmpresa.jsp";
	}

}
