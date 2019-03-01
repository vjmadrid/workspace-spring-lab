package com.acme.example.custom.message.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {

	private static final Logger LOG = LoggerFactory.getLogger(PropertiesConfig.class);
	
	@Autowired
	private Environment environment;
	
	@Value("${app.version}")
    private String appVersion;
	
	@Value("${profiles.active}")
    private String profile;
	
	@PostConstruct
	public void setup() {
			
	}

           
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}