package com.bastelbude.timeline.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        return dataSourceBuilder
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:6666/timeline")
                .username("timeline")
                .password("timeline")
                .build();
    }
}
