package br.com.alura.gerenciador.servlet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.alura.gerenciador.servlet.model.entity.Empresa;

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
		empresas.removeIf(x -> x.getId() == id);
	}

	public Empresa findById(Integer id) throws IllegalAccessException {
		for (Empresa empresa : empresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		throw new IllegalAccessException("ID: " + id + ", não existe!");
	}
}
