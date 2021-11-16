package com.shipunovm.skblab.dao.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.shipunovm.skblab.dao")
@ComponentScan("com.shipunovm.skblab.dao")
@EntityScan("com.shipunovm.skblab.domain")
@EnableAutoConfiguration
public class DaoConfig {

}
