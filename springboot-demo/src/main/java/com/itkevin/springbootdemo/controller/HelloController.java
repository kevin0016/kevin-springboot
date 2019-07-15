package com.itkevin.springbootdemo.controller;

import com.itkevin.springbootdemo.SpringbootDemoApplication;
import com.itkevin.springbootdemo.component.InvalidInitExampleBean;
import com.itkevin.springbootdemo.service.Aservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootDemoApplication.class);

    @Autowired
    private Environment environment;

    @Autowired
    private InvalidInitExampleBean exampleBean;

    @Autowired
    private Aservice aservice;

    @GetMapping(value = "hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping(value = "test")
    public String test() {
        LOGGER.error(environment.toString());
        LOGGER.error(exampleBean.nullTest());
        return aservice.testDemo();
    }
}
