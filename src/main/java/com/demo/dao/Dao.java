package com.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

public class Dao implements IDao {

	public SessionFactory sessionFactory = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List getObjects(Class clazz) {
		// TODO Auto-generated method stub
		String[] ss = clazz.getName().split("\\.");
		List list = null;
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			String queryString = "from " + ss[ss.length - 1];
			tx = session.beginTransaction();
			list = session.createQuery(queryString).list();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Object getObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		Object o = null;
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			o = session.get(clazz.getName(), id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return o;
	}

	@Override
	public void SaveObject(Object o) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(o);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteObject(Object o) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List getObjectsByProperty(Class clazz, String propertyName,
			Object value) {
		// TODO Auto-generated method stub
		String[] ss = clazz.getName().split("\\.");
		List list = null;
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			String queryString = "from " + ss[ss.length - 1] + " as m where m."
					+ propertyName + "= ?";
			tx = session.beginTransaction();
			list = session.createQuery(queryString).list();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getObjectsByProperty(Class clazz, String propertyName,
			Object value, int start, int limit) {
		// TODO Auto-generated method stub
		String[] ss = clazz.getName().split("\\.");
		List list = null;
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			String queryString = "from " + ss[ss.length - 1] + " as m where m."
					+ propertyName + "= ?";
			tx = session.beginTransaction();
			list = session.createQuery(queryString)
					.setFirstResult(start)
					.setMaxResults(limit).list();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getObjectsBySql(Class clazz, String queryString) {
		// TODO Auto-generated method stub
		List list = null;
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createSQLQuery(queryString).setResultTransformer(Transformers.aliasToBean(clazz)).list();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List getMapObjectsBySql(String queryString) {
		// TODO Auto-generated method stub
		List list = null;
		Session session = SessionFactoryUtils.openSession(sessionFactory);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createSQLQuery(queryString).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

}
