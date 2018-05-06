package br.com.drogaria.main;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRIÇÃO A");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRIÇÃO B");

		Fabricante f3 = new Fabricante();

		FabricanteDAO dao = new FabricanteDAO();
		// CHAMANDO OS FABRICANTES 1 E 2
		dao.salvar(f1);
		dao.salvar(f2);
		dao.salvar(f3);

	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		
		//PODEMOS LISTAR DIRETO AQUI SEM O USO DO FOR
		//MAS A BUSCA FICA FEIOSA
		//System.out.println(fabricante);


		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(3L);
		Fabricante f2 = dao.buscarPorCodigo(7L);

		System.out.println(f1);
		System.out.println(f2);

	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(2L);
		//if(fabricante != null){
		dao.excluir(fabricante);
		
		
		// Fabricante fabricante = fabricante();
		// fabricante.setCodigo(5L);
		// fabricante.setDescricao("DESCRICAOA");
		//
		// FabricanteDAO dao = new FabricanteDAO()
		// dao.excluir(fabricante);
	}
	
//	@Test
//	@Ignore
//	public void excluirPorCodigo() {
//		FabricanteDAO dao = new FabricanteDAO();
//		dao.excluir(5L);
//		}
		
	
	@Test
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscarPorCodigo(2L);
		//if(fabricante != null){
		fabricante.setDescricao("DESCRIÇÃO NOVA");
		dao.editar(fabricante);
//		Fabricante fabricante = new Fabricante();
//		fabricante.setCodigo(1L);
//		fabricante.setDescricao("DESCRICAOX");
//		
//		FabricanteDAO dao = new FabricanteDAO();
//		dao.editar(fabricante);
		}
}
