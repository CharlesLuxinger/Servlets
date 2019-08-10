package br.com.alura.gerenciador.servlet.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.servlet.entity.Empresa;

public class DB {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();

	public void addDb(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	public static List<Empresa> getEmpresas() {
		return empresas;
	}
}
