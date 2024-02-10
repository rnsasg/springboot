package com.narayan.springdatajdbc.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigDataSource {
    public static DataSource source(){
        DataSourceBuilder<?> dSB = DataSourceBuilder.create();
        dSB.driverClassName("com.mysql.cj.jdbc.Driver");
        dSB.url("jdbc:mysql://localhost:3306/userdetails");
        dSB.username("user");
        dSB.password("password");
        return dSB.build();
    }
}