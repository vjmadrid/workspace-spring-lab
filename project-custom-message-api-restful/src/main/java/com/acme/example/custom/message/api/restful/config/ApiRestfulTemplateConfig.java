package com.acme.example.custom.message.api.restful.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.example.custom.message.api.restful.constant.GeneralCustomMessageRestfulConfigConstant;

@Configuration
@ComponentScan(basePackages = { GeneralCustomMessageRestfulConfigConstant.GENERIC_PACKAGE })
public class ApiRestfulTemplateConfig {

}
