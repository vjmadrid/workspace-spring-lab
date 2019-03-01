package com.acme.example.custom.message.config.environment;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.acme.example.custom.message.constant.GeneralCustomMessageConfigConstant;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@PropertySources({
	@PropertySource("classpath:persistence/dev-persistence.properties")
})
@Profile(SpringConfigConstant.SPRING_PROFILE_DEVELOPMENT)
public class DevelopmentConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfig.class);
	
	@Autowired
    private Environment env;
	
	@Bean(name="dataSource")
    public DataSource dataSourceDev() {
		LOG.debug("[CONFIGURATION] Configuring Datasource in DEV ...");
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(GeneralCustomMessageConfigConstant.PROP_DATABASE_DRIVER));
        dataSource.setUrl(env.getProperty(GeneralCustomMessageConfigConstant.PROP_DATABASE_URL));
        dataSource.setUsername(env.getProperty(GeneralCustomMessageConfigConstant.PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getProperty(GeneralCustomMessageConfigConstant.PROP_DATABASE_PASSWORD));
        return dataSource;
    }
    
	@Bean(name="liquibase")
    public SpringLiquibase liquibase() {
		LOG.debug("[CONFIGURATION] Configuring Liquibase int DEV");
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/liquibase-changeLog.xml");
        liquibase.setDataSource(dataSourceDev());
        liquibase.setDropFirst(true);
        return liquibase;
    }
	
	@Bean(name="hibernateProperties")
	public Properties hibernateProperties() {
		LOG.debug("[CONFIGURATION] Configuring hibernateProperties in DEV ...");
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(GeneralCustomMessageConfigConstant.PROP_HIBERNATE_HBM2DDL_AUTO, env.getProperty(GeneralCustomMessageConfigConstant.PROP_HIBERNATE_HBM2DDL_AUTO));
		hibernateProperties.setProperty(GeneralCustomMessageConfigConstant.PROP_HIBERNATE_DIALECT, env.getProperty(GeneralCustomMessageConfigConstant.PROP_HIBERNATE_DIALECT));
		hibernateProperties.setProperty(GeneralCustomMessageConfigConstant.PROP_HIBERNATE_SHOW_SQL, env.getProperty(GeneralCustomMessageConfigConstant.PROP_HIBERNATE_SHOW_SQL));
		return hibernateProperties;
	}
    
}