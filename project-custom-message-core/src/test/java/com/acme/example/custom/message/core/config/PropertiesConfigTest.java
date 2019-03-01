package com.acme.example.custom.message.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.acme.example.custom.message.config.PropertiesConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PropertiesConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PropertiesConfigTest {

    @Autowired
    private Environment env;
    
    @Value("${app.version}")
    private String appVersion;

    @Value("${profiles.active}")
    private String profile;

    @Test
    public final void givenContextIsInitialized_thenNoException() {
    	assertEquals("Draft", appVersion);
    	assertEquals("dev", profile);
    	assertEquals("dev", env.getProperty("profiles.active"));
    }

}
