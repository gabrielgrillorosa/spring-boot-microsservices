package com.gabriel.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.gabriel.authentication.config.JwtConfiguration;


@SpringBootApplication
@EnableConfigurationProperties(value = JwtConfiguration.class)
public class AuhtenticationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuhtenticationServerApplication.class, args);
		/*
		 * gerando senha criptografada para colocar no banco 
		 */
		System.out.println(new BCryptPasswordEncoder().encode("senha"));
		
	}

}
