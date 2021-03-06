package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {
		// PEGANDO A FABRICA DE SESS�O CAPTURA E ARMAZENA
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(fabricante);
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
	public List<Fabricante> listar() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;

		try {
			Query consulta = session.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return fabricantes;
	}

	public Fabricante buscarPorCodigo(Long codigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;

		try {
			Query consulta = session.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return fabricante;
	}

	public void excluir(Fabricante fabricante) {
		// PEGANDO A FABRICA DE SESS�O CAPTURA E ARMAZENA
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(fabricante);
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
//		// PEGANDO A FABRICA DE SESS�O CAPTURA E ARMAZENA
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

	public void editar(Fabricante fabricante) {
		// PEGANDO A FABRICA DE SESS�O CAPTURA E ARMAZENA
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
			fabricanteEditar.setDescricao(fabricante.getDescricao());
			session.update(fabricanteEditar);

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