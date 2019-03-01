package com.acme.example.spring.testing.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import static org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-configuration/custom-listener-context-test.xml")
//@TestExecutionListeners({
//	CustomTestExecutionListener.class
//})
//@TestExecutionListeners({
//	CustomTestExecutionListener.class,
//	ServletTestExecutionListener.class,
//	DependencyInjectionTestExecutionListener.class,
//	DirtiesContextTestExecutionListener.class,
//	TransactionalTestExecutionListener.class,
//	SqlScriptsTestExecutionListener.class
//})
@TestExecutionListeners(
		listeners = CustomTestExecutionListener.class,
		mergeMode = MergeMode.MERGE_WITH_DEFAULTS
)
public class CustomTestExecutionListenerTest {
	
	@Test
	public void someTest() throws Exception {
		System.out.println("executing someTest");
	}
	
	@Test
	public void someOtherTest() throws Exception {
		System.out.println("executing someOtherTest");
	}
	
}
