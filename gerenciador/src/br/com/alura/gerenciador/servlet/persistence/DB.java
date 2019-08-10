package br.com.alura.gerenciador.servlet.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.servlet.entity.Empresa;

public class DB {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	static {
		empresas.add(new Empresa(null, "Google"));
		empresas.add(new Empresa(null, "Amazon"));
	}

	public void addDb(Empresa empresa) {
		empresas.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return empresas;
	}
}
