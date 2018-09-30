package com.kevin.springboot.flux.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 双数据源定义
 * @Auther: liangxuekai
 * @Date: 18/9/27 17:20
 * @Description:
 */
@Configuration
public class MultipleDataSourceConfiguration {

    @Bean
    @Primary
    public DataSource masterDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://192.168.20.15:3306/flow_iot")
                .username("flow")
                .password("flow2108")
                .build();
        return dataSource;
    }

    @Bean
    public DataSource salveDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://192.168.20.15:3306/flow_iot")
                .username("flow")
                .password("flow2108")
                .build();
        return dataSource;
    }
}
