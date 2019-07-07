package com.itkevin.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/**
 * @projectName: kevin-springboot
 * @className: SecurityConfig
 * @description:
 * @author: liangxuekai
 * @createDate: 2019-07-07 11:07
 * @updateUser: liangxuekai
 * @updateDate: 2019-07-07 11:07
 * @updateRemark: 修改内容
 * @version: 1.0
 */
@Profile("dev")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 高版本的SpringSecurity中对于url中的双斜杠问题做了限制
     * 此处放开这个双斜杠防火墙限制
     * @return
     */
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
//        super.configure(web);
    }

}
