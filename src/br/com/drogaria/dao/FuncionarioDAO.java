package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.HibernateUtil;

public class FuncionarioDAO {
	
	public void salvar(Funcionario funcionario) {
		// PEGANDO A FABRICA DE SESSÃO CAPTURA E ARMAZENA
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(funcionario);
			transaction.commit();

		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Funcionario> funcionarios = null;

		try {
			Query consulta = session.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return funcionarios;
	}

	public Funcionario buscarPorCodigo(Long codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;

		try {
			Query consulta = session.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return funcionario;
	}

	public void excluir(Funcionario funcionario) {
		// PEGANDO A FABRICA DE SESSÃO CAPTURA E ARMAZENA
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(funcionario);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}

	}

//	public void excluir(Long codigo) {
//		// PEGANDO A FABRICA DE SESSÃO CAPTURA E ARMAZENA
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = null;
//
//		try {
//			transaction = session.beginTransaction();
//			Fabricante fabricante = buscarPorCodigo(codigo);
//			session.delete(fabricante);
//			transaction.commit();
//		} catch (RuntimeException ex) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			throw ex;
//		} finally {
//			session.close();
//		}
//
//	}

	public void editar(Funcionario funcionario) {
		// PEGANDO A FABRICA DE SESSÃO CAPTURA E ARMAZENA
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.update(funcionario);
			transaction.commit();

		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();

			}
			throw ex;
		} finally {
			session.close();
		}

	}

	
	

}
