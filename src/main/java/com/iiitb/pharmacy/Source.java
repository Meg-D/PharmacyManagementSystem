package com.iiitb.pharmacy;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Source {
    @Bean
    public DataSource getdataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        String url = System.getenv("DATABASE_HOST");
        if (url != null) {
            dataSourceBuilder.url("jdbc:mysql://mysql-db-tgl:3306/pms?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
        } else {
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/pms?createDatabaseIfNotExist=true");
        }
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("C@sper7197");
        return dataSourceBuilder.build();
    }
}

