package br.com.drogaria.main;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(4L);

		Produto produto = new Produto();
		produto.setDescricao("DESCRIACAO n");
		produto.setPreco(new BigDecimal(20.55D));
		produto.setQuantidade(4);
		produto.setFabricante(fabricante);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);

		System.out.println(produto);

	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		List<Produto> produtos = produtoDAO.listar();
		System.out.println(produtos);
	}

	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(3L);

		produtoDAO.excluir(produto);
	}

	@Test
	public void editar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);

		produto.setDescricao("DESCRICAO SÓ UMA COISA");
		produto.setPreco(new BigDecimal(15.30));
		produto.setQuantidade(9);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();

		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);
		produto.setFabricante(fabricante);

		produtoDAO.editar(produto);
	}

}
