package com.itkevin.springbootdemo;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * @author kevin
 */
@SpringBootApplication
@EnableAdminServer
@EnableSwagger2Doc
@MapperScan(basePackages = "com.koolearn")
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


    /**
     * prod 环境加载
     */
    @Profile("prod")
    @Configuration
    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
        private final String adminContextPath;

        public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
            this.adminContextPath = adminServerProperties.getContextPath();
        }

//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            super.configure(web);
//            web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
//        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
            successHandler.setTargetUrlParameter("redirectTo");

            http.authorizeRequests()
                    .antMatchers(adminContextPath + "/assets/**").permitAll()
                    .antMatchers(adminContextPath + "/login").permitAll()
                    .antMatchers(adminContextPath+"v2/**").permitAll()
                    .antMatchers(adminContextPath+"/swagger-resources/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
                    .logout().logoutUrl(adminContextPath + "/logout").and()
                    .httpBasic().and()
                    .csrf().disable();
        }
    }


}
