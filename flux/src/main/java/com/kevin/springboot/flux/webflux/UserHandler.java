package com.kevin.springboot.flux.webflux;

import com.kevin.springboot.flux.domain.User;
import com.kevin.springboot.flux.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Auther: liangxuekai
 * @Date: 18/9/27 14:51
 * @Description:
 */
@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        System.out.printf("[Thread:%s] start saving user...\n" ,Thread.currentThread().getName());
        //在spring WEB MVC中使用@RequestBody
        //在spring WEB FLUX中使用serverRequest
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        Mono<Boolean> booleanMono = userMono.map(userRepository::save);
        return ServerResponse.ok().body(booleanMono, Boolean.class);

    }

}
