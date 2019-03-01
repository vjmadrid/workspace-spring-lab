package com.acme.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.acme.example.entity.User;
import com.acme.example.repository.UserDao;
import com.acme.example.service.UserService;

@Service ("userService")
public class UserServiceImpl implements UserService {

	private final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Resource
	@Qualifier ("userDaoInMemory")
	private UserDao userDao;
	
    public List<User> findAllUsers() {
    	LOG.trace("Find all Users");
        return userDao.findAll();
    }
    
    public User findUser(Long id) {
    	LOG.trace("Find User with id : {}", id);
    	return userDao.findByPK(id);
    }

    public void saveUser(User user) {
    	LOG.trace("Create User with id : {}", user.getId());
    	userDao.update(user);
    }

    public void updateUser(User user) {
    	LOG.trace("Update User with id : {}", user.getId());
    	userDao.update(user);
    }
    
    public void deleteUser(User user) {
    	LOG.trace("Delete User with id : {}", user.getId());
    	userDao.remove(user);
    }

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
    
}
