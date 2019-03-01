package com.acme.example.spring.testing.transactional;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-configuration/persistence-context-test.xml")
//@Transactional
public class TransactionalTest {

	@Autowired
	private SessionFactory sessionFactory;

	@BeforeTransaction
	public void setUp() {
	
	}

	@AfterTransaction
	public void tearDown() {
	
	}

	@Test
	@Transactional
	public void testTransactional1() {
	}

	@Test
	@Rollback(false)
	public void testTransactional2() {
		
	}
	
	@Test
	public void testInjections() {
		assertNotNull(sessionFactory);
	}
}
