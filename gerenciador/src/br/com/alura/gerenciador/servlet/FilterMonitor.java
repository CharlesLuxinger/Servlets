package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/main")
public class FilterMonitor implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Long init = System.currentTimeMillis();
		String action = request.getParameter("action");
		chain.doFilter(request, response);

		System.out.println(action + " execution time: " + (System.currentTimeMillis() - init) + " ms");
	}

}
