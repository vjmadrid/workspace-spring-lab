package com.acme.example.custom.message.repository;

import com.acme.architecture.persistence.repository.GenericRepository;
import com.acme.example.custom.message.entity.CustomMessage;

public interface CustomMessageRepository extends GenericRepository<CustomMessage, Long> {

}
