package com.acme.example.custom.message.core.config.persistence;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.acme.example.custom.message.core.constant.GeneralCustomMessageConfigConstant;

@Configuration
@EnableTransactionManagement
@ComponentScan({ GeneralCustomMessageConfigConstant.REPOSITORY_PACKAGE })
public class PersistenceHibernateConfig {

	private static final Logger LOG = LoggerFactory.getLogger(PersistenceHibernateConfig.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private Properties hibernateProperties;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LOG.debug("[CONFIGURATION] Configuring sessionFactory ...");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { GeneralCustomMessageConfigConstant.ENTITY_PACKAGE, GeneralCustomMessageConfigConstant.DOMAIN_PACKAGE });
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		LOG.debug("[CONFIGURATION] Configuring transactionManager ...");
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
}