package com.acme.example.spring.testing.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class CustomTestExecutionListener implements TestExecutionListener {

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		ApplicationContext context = testContext.getApplicationContext();
		System.out.println("In afterTestClass for class ="+testContext.getTestClass());
	}

	@Override
	public void afterTestMethod(TestContext testContext) throws Exception {
		System.out.println("In afterTestMethod for ="+testContext.getTestMethod().getName());
	}

	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		System.out.println("In beforeTestClass for class ="+testContext.getTestClass());
	}

	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		System.out.println("In beforeTestMethod for ="+testContext.getTestMethod().getName());
	}

	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		System.out.println("In prepareTestInstance for="+testContext.getTestInstance());
	}

}
