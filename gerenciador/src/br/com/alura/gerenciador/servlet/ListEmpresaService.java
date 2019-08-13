package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.servlet.model.DB;
import br.com.alura.gerenciador.servlet.model.entity.Empresa;

@WebServlet("/empresas")
public class ListEmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = DB.getEmpresas();
		
		/*
		 * Gson gson = new Gson(); String json = gson.toJson(empresas);
		 * 
		 * response.setContentType("applicattion/json");
		 * response.getWriter().print(json);
		 */
		
		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String json = xstream.toXML(empresas);
		
		response.setContentType("applicattion/xml");
		response.getWriter().print(json);
	}

}
