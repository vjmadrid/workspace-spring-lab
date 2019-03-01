package com.acme.example.repository;

import com.acme.architecture.persistence.repository.GenericRepository;
import com.acme.example.entity.User;

public interface UserDao extends GenericRepository<User, Long> {
	 
}
