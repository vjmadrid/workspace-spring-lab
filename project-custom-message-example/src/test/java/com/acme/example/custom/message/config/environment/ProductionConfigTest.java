package com.acme.example.custom.message.config.environment;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ProductionConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.SPRING_PROFILE_PRODUCTION})
public class ProductionConfigTest {
	
	//@Autowired
	//private DataSource dataSource;
	
	@Test
	public void shouldBeInjected() {
		assertNotNull(true);
	}
}
