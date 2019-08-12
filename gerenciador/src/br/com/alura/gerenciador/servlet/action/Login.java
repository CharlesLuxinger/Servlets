package br.com.alura.gerenciador.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.servlet.model.DB;
import br.com.alura.gerenciador.servlet.model.entity.User;

public class Login implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		User userOn = new User(login, password);
		
		if (DB.findUser(userOn)) {
			HttpSession session = request.getSession();
			session.setAttribute("userLogon", userOn);
			
			return "redirect:main?action=ListEmpresa";
		}
		return "redirect:main?action=LoginForm";
	}

}
