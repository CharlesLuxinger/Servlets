package br.com.alura.gerenciador.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
