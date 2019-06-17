package com.acme.example.custom.message.config.persistence;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.acme.example.custom.message.core.config.environment.DevelopmentConfig;
import com.acme.example.custom.message.core.config.persistence.PersistenceHibernateConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DevelopmentConfig.class ,PersistenceHibernateConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.SPRING_PROFILE_DEVELOPMENT})
public class PersistenceHibernateConfigTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(sessionFactory);
	}
}
