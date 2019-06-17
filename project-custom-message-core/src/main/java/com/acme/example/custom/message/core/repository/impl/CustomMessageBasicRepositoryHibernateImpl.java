package com.acme.example.custom.message.core.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.repository.CustomMessageBasicRepository;

@Repository("customMessageBasicRepository")
public class CustomMessageBasicRepositoryHibernateImpl implements CustomMessageBasicRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public CustomMessageBasicRepositoryHibernateImpl() {
		super();
	}

	public CustomMessageBasicRepositoryHibernateImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<CustomMessage> findAll() {
		@SuppressWarnings("unchecked")
		List<CustomMessage> result = (List<CustomMessage>) sessionFactory.getCurrentSession()
				.createCriteria(CustomMessage.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return result;
	}

	@Override
	@Transactional
	public CustomMessage findByPK(long id) {
		String hql = "from CustomMessage where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<CustomMessage> listUser = (List<CustomMessage>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
		return null;
	}

	@Override
	@Transactional
	public void saveOrUpdate(CustomMessage user) {
		
		if (user.getId()==null) {
			sessionFactory.getCurrentSession().save(user);
		} else {
			CustomMessage userMessageFound = findByPK(user.getId());
			if (userMessageFound!=null) {
				sessionFactory.getCurrentSession().merge(user);
			} else {
				sessionFactory.getCurrentSession().save(user);
			}
		}
	
	}

	@Override
	@Transactional
	public void delete(CustomMessage userMessage) {
		sessionFactory.getCurrentSession().delete(userMessage);

	}

}
