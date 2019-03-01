package com.acme.example.custom.message.repository.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.architecture.persistence.repository.GenericRepository;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T, PK extends Serializable> implements GenericRepository<T, PK> {
	
    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    // API

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }
    
    @Override
	public final void insert(final T object) {
    	getCurrentSession().save(object);
	}

	@Override
	public final void remove(final T object) {
		getCurrentSession().delete(object);
	}

	@Override
	public final void update(final T object) {
		getCurrentSession().saveOrUpdate(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final List<T> findAll() {
		return ((List<T>) getCurrentSession().createCriteria(clazz).list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public final T findByPK(final PK id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public final List<T> findByQuery(final String query) {
		return ((List<T>) getCurrentSession().createQuery(query).list());
	}

	public Query createQuery(final String query) {
		return (Query) getCurrentSession().createQuery(query);
	}
	
	private Query createQueryWithParams(final String query,
			final Map<String, Object> params) {
		Query qQuery = (Query) getCurrentSession().createQuery(query);
		if (params != null) {
			Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				Object value = params.get(key);
				qQuery.setParameter(key, value);
			}
		}
		return qQuery;
	}

	@SuppressWarnings("unchecked")
	public final List<T> findByQueryParameters(final String query,
			final Map<String, Object> params) {
		Query qQuery = createQueryWithParams(query, params);
		return ((List<T>) qQuery.list());
	}

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}