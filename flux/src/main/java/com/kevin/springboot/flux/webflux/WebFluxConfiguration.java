package com.kevin.springboot.flux.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Web Flux 配置
 *
 * @Auther: liangxuekai
 * @Date: 18/9/27 14:45
 * @Description:
 */
@Configuration
public class WebFluxConfiguration {

    @Bean
    public RouterFunction<ServerResponse> saveUser(UserHandler userHandler) {
        return route(POST("/web/flux/user/save"), userHandler::save);
    }
}
