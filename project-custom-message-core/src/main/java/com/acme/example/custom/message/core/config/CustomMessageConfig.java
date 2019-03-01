package com.acme.example.custom.message.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.example.custom.message.constant.GeneralCustomMessageConfigConstant;

@Configuration
@ComponentScan(basePackages = { GeneralCustomMessageConfigConstant.BASE_PACKAGE })
public class CommonTemplateConfig {
	
}
