package br.com.drogaria.main;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDAOTeste {

	@Test
	@Ignore
	public void salvar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("122.111.111-11");
		funcionario.setFuncao("ADMISTRADOR");
		funcionario.setNome("ANA");
		funcionario.setSenha("12345");

		FuncionarioDAO dao = new FuncionarioDAO();
		// CHAMANDO OS FABRICANTES 1 E 2
		dao.salvar(funcionario);
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO dao = new FuncionarioDAO();

		List<Funcionario> funcionarios = dao.listar();

		System.out.println(funcionarios);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(3L);

		System.out.println(funcionario);

	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(2L);
		dao.excluir(funcionario);

	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscarPorCodigo(2L);

		funcionario.setCpf("444.444.444-44");
		funcionario.setFuncao("USUARIO");
		funcionario.setNome("BINGO");
		funcionario.setSenha("qualquercoisa");

		dao.editar(funcionario);
	}

}
