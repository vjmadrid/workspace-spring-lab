package com.acme.example.custom.message.config.environment;

import java.util.Properties;

import javax.naming.NamingException;
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

import com.acme.architecture.common.constant.SpringConfigConstant;

@Configuration
@PropertySources({
	@PropertySource("classpath:persistence/pro-persistence.properties")
})
@Profile(SpringConfigConstant.SPRING_PROFILE_PRODUCTION)
public class ProductionConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductionConfig.class);
	
	@Autowired
    private Environment env;
	
	@Bean(name="dataSource")
    public DataSource dataSourceProduction() throws NamingException {
		LOG.debug("[CONFIGURATION] Configuring Datasource in PRO ...");
		return null;
       // return (DataSource) new JndiTemplate().lookup(env.getProperty(ConfigConstant.PROP_JNDI));
    }
	
	@Bean(name="hibernateProperties")
	public Properties hibernateProperties() {
		LOG.debug("[CONFIGURATION] Configuring hibernateProperties in PRO ...");
		final Properties hibernateProperties = new Properties();
		return hibernateProperties;
	}

}