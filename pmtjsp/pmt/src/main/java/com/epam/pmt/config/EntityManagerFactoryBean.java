package com.epam.pmt.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EntityManagerFactoryBean {
	@Bean
	public  EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("my-mysql-unit");
	}

}
