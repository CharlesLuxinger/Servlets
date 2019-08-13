package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.servlet.model.DB;
import br.com.alura.gerenciador.servlet.model.entity.Empresa;

@WebServlet("/empresas")
public class ListEmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = DB.getEmpresas();

		String header = request.getHeader("accept");
		String responseStr = null;

		if (header.endsWith("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			responseStr = xstream.toXML(empresas);
		} else if (header.endsWith("json")) {
			Gson gson = new Gson();
			responseStr = gson.toJson(empresas);
		} else {
			throw new ServletException("Tipo: " + responseStr + ", inválido!");
		}

		response.setContentType(header);
		response.getWriter().print(responseStr);
	}

}
