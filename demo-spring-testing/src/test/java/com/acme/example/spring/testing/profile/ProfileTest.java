package com.acme.example.spring.testing.profile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-configuration/profile-context-test.xml")
@ActiveProfiles(profiles={"dev"})
//@ActiveProfiles(profiles={"dev"}) //Caso 1
//@ActiveProfiles(profiles={"dev","prod"}) //Caso 2 : Siempre ejecuta el ultimo
//Caso 3: Uso de la variable spring.profiles.active = dev (Configurar en environment de test)
//Caso 4: -Dspring.profiles.active= profile1
public class ProfileTest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void profile() throws Exception {
		assertEquals("I'm a free bean", context.getBean("noProfileBean"));
		assertEquals("I'm a dev bean", 	context.getBean("message"));
	}
	
}
