package com.itkevin.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 */
@RestController
public class HelloController {

    @GetMapping(value = "hello")
    public String hello(){
        return "hello world";
    }
}
