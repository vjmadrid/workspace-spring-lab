package com.acme.example.custom.message.core.environment;

import static org.junit.Assert.assertNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.acme.example.custom.message.core.config.environment.CloudConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CloudConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.SPRING_PROFILE_CLOUD})
public class CloudConfigTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void shouldBeInjected() {
		assertNull(dataSource);
	}
}
