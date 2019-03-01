package com.acme.example.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.acme.architecture.persistence.repository.test.impl.GenericMapInMemoryRepositoryImpl;
import com.acme.example.entity.User;
import com.acme.example.factory.UserDataFactory;
import com.acme.example.repository.UserDao;

@Repository ("userDaoInMemory")
public class UserDaoInMemoryImpl extends GenericMapInMemoryRepositoryImpl<User, Long> implements UserDao {

	@PostConstruct
	public void setup() {
		setEntityMap(UserDataFactory.createSampleUserMap());
	}
	
	public List<User> findAll() {
		return new ArrayList<User>(getEntityMap().values());
	}

	public User findByPK(Long userId) {
		return getEntityMap().get(userId);
	}

	public List<User> findByQuery(String userId) {
		return new ArrayList<User>(getEntityMap().values());
	}

	public List<User> findByQueryParameters(String query,
			Map<String, Object> parameters) {
		return new ArrayList<User>(getEntityMap().values());
	}

	public void insert(User user) {
		getEntityMap().put(user.getId(), user);
	}

	public void remove(User user) {
		getEntityMap().remove(user.getId());
	}

	public void update(User user) {
		getEntityMap().put(user.getId(), user);
	}

}	
	