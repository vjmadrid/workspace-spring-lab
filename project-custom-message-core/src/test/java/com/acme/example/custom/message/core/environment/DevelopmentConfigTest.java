package com.acme.example.custom.message.core.environment;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.acme.example.custom.message.core.config.environment.DevelopmentConfig;

import liquibase.integration.spring.SpringLiquibase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DevelopmentConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.SPRING_PROFILE_DEVELOPMENT})
public class DevelopmentConfigTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SpringLiquibase liquibase;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(dataSource);
		assertNotNull(liquibase);
	}
}
