package com.acme.spring.core.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorldLifeCycle implements ApplicationContextAware,BeanNameAware, InitializingBean,
		BeanFactoryAware,BeanPostProcessor,  DisposableBean {

	private String message;

	public String getMessage() {
		System.out.println("Llamada a getMessage con " + message);
		return message;
	}
	
	@Autowired
	public void setMessage(String message) {
		System.out.println("Llamada a setMessage con " + message);
		this.message = message;
	}	
	
	
	public void setBeanName(String arg0) {
		System.out.println("Llamada a setBeanName con " + arg0);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Llamada a afterPropertiesSet ");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("Llamada a setBeanFactory");
	}

	public void myInit() {
		System.out.println("Llamada a custom myInit");
	}

	public void myDestroy() {
		System.out.println("Llamada a myDestroy");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Llamada a destroy ");// TODO Auto-generated method stub
	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("Llamada a postProcessAfterInitialization con "+arg0+" y "+arg1);
		return null;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("Llamada a postProcessBeforeInitialization con "+arg0+" y "+arg1);
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("Llamada a setApplicationContext");	
	}

}
