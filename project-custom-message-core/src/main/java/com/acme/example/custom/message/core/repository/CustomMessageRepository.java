package com.acme.example.custom.message.core.repository;

import com.acme.architecture.persistence.repository.GenericRepository;
import com.acme.example.custom.message.core.entity.CustomMessage;

public interface CustomMessageRepository extends GenericRepository<CustomMessage, Long> {

}
