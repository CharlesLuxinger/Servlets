package br.com.alura.gerenciador.servlet.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import br.com.alura.gerenciador.servlet.entity.Empresa;

public class DB {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	static {
		empresas.add(new Empresa(chaveSequencial++, "Google", new Date()));
		empresas.add(new Empresa(chaveSequencial++, "Amazon", new Date()));
	}

	public void addDb(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		empresas.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return empresas;
	}

	public void removeEmpresaById(Integer id) {
		/*
		 * Iterator<Empresa> it = empresas.iterator();
		 * 
		 * while (it.hasNext()) { Empresa emp = it.next(); if (emp.getId() == id) {
		 * it.remove(); } }
		 */
		
		empresas.removeIf(x -> x.getId() == id);
	}
}
