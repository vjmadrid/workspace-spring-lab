package com.acme.example.custom.message.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@PropertySource("classpath:application.properties")
public class ProfileConfig {

	private static final Logger LOG = LoggerFactory.getLogger(ProfileConfig.class);
	
	@Autowired
	ConfigurableEnvironment configurableEnvironment;
	
	@Value("${profiles.active}")
    private String profile;
	
	@PostConstruct
	public void setup() {
		getActiveProfiles();	
		changeProfile();
	}
	
    public String getActiveProfiles() {
    	String result =  Arrays.toString(configurableEnvironment.getActiveProfiles());
        LOG.info("Application running using profiles: {}", result);
        return result;
    }
    
    public void changeProfile() {
    	String activeProfiles[] = configurableEnvironment.getActiveProfiles();
        if (activeProfiles.length == 0) {
        	 LOG.info("No have Active Profiles used by Spring");
        	 LOG.info("Using property profile {}", profile);
        	 configurableEnvironment.setActiveProfiles(profile);
        	 getActiveProfiles();
        }       
    }
        
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}