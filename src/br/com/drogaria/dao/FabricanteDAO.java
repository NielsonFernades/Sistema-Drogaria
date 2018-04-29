package br.com.drogaria.dao;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = (Transaction) sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();

		} catch (Exception e) {
			if (transacao != null) {
				try {
					transacao.rollback();
				} catch (IllegalStateException | SystemException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			sessao.close();
		}

	}
}