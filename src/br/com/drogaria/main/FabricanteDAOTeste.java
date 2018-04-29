package br.com.drogaria.main;

import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTeste {

	@Test
	private void salvar() {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Descri��o");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("Descri��o");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);

	}
}
