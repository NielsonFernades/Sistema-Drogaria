package br.com.drogaria.main;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ItemDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;

public class ItemDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		//CHAVE EXTRAGEIRA PRODUTO
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);

		//CHAVE EXTRANGEIRA VENDA
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(3L);

		Item item = new Item();
		item.setProduto(produto); // SETANDO A CHAVE ESTRANGEIRA DA PRODUTO
		item.setQuantidade(4);
		item.setValor(new BigDecimal(89.53D));
		item.setVenda(venda); // SETANDO A CHAVE ESTRANGEIRA DA VENDA

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);

		System.out.println(item);
	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();

		List<Item> itens = itemDAO.listar();
		System.out.println(itens);
	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);

		itemDAO.excluir(item);
	}

	@Test
	@Ignore
	public void editar() {
		//CHAVE EXTRAGEIRA PRODUTO
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);

		//CHAVE EXTRAGEIRA VENDA
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(3L);

		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);

		item.setProduto(produto);
		item.setQuantidade(3);
		item.setValor(new BigDecimal(11.30));
		item.setVenda(venda);

		vendaDAO.editar(venda);
	}

}
