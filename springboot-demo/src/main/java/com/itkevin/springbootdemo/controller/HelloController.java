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
        if(1==1)
            System.out.println(2);
        return "hello world";
    }
}
