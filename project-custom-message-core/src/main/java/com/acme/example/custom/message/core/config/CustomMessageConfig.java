package com.acme.example.custom.message.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.example.custom.message.core.constant.GeneralCustomMessageConfigConstant;

@Configuration
@ComponentScan(basePackages = { GeneralCustomMessageConfigConstant.BASE_PACKAGE })
public class CustomMessageConfig {
	
}
