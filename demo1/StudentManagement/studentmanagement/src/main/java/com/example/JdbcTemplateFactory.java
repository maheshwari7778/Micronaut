package com.example;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Factory
public class JdbcTemplateFactory {

    @Inject
    DataSource dataSource;

    @Bean
    @Singleton
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}