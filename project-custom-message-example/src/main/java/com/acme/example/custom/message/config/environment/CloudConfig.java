package com.acme.example.custom.message.config.environment;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acme.architecture.common.constant.SpringConfigConstant;

@Configuration
@Profile(SpringConfigConstant.SPRING_PROFILE_CLOUD)
public class CloudConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(CloudConfig.class);
	
	@Bean(name="dataSource")
    public DataSource dataSourceCloud() throws NamingException {
		LOG.debug("[CONFIGURATION] Configuring Datasource in CLOUD ...");
        return null;
    }

}