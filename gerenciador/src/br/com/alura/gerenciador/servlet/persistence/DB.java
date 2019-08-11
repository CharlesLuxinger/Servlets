package br.com.alura.gerenciador.servlet.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.alura.gerenciador.servlet.entity.Empresa;

public class DB {

	private static List<Empresa> empresas = new ArrayList<Empresa>();

	static {
		empresas.add(new Empresa(null, "Google", new Date()));
		empresas.add(new Empresa(null, "Amazon", new Date()));
	}

	public void addDb(Empresa empresa) {
		empresas.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return empresas;
	}
}
