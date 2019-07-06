package com.itkevin.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @author kevin
 */
@SpringBootApplication
public class SpringbootDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootDemoApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootDemoApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        Arrays.stream(activeProfiles).forEach(profile->
            LOGGER.debug("Spring Boot 使用profile为:{}",profile)
        );
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        // 目的是
        return args -> {
            System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            Arrays.stream(beanNames).forEach(System.out::println);
        };
    }

}
