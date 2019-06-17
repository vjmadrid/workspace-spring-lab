package com.acme.example.custom.message.core.constant;

public final class GeneralCustomMessageConfigConstant {

	private GeneralCustomMessageConfigConstant() {
	}

	public static final String BASE_PACKAGE = "com.acme.example.custom.message.core";
	public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".entity";
	public static final String DOMAIN_PACKAGE = BASE_PACKAGE + ".domain";
	public static final String REPOSITORY_PACKAGE = BASE_PACKAGE + ".repository";
	public static final String DAO_PACKAGE = BASE_PACKAGE + ".dao";
	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
	
	public static final String PROP_DATABASE_DRIVER = "datasource.driverClassName";
	public static final String PROP_DATABASE_URL = "datasource.url";
	public static final String PROP_DATABASE_USERNAME = "datasource.username";
	public static final String PROP_DATABASE_PASSWORD = "datasource.password";
	
	public static final String PROP_JNDI = "jdbc.jndiDataSource";
	
	public static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
	public static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	public static final String PROP_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	

}
