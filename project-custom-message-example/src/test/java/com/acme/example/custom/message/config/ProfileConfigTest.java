package com.acme.example.custom.message.config;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ProfileConfig.class })
@ActiveProfiles(profiles={SpringConfigConstant.SPRING_PROFILE_CLOUD})
public class ProfileConfigTest {

	@Autowired
	ConfigurableEnvironment configurableEnvironment;

    @Test
    public final void givenContextIsInitialized_thenNoException() {
    	String result =  Arrays.toString(configurableEnvironment.getActiveProfiles());
        assertEquals("["+SpringConfigConstant.SPRING_PROFILE_CLOUD+"]", result);
    }

}
