package com.itkevin.springcloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: kevin-springboot
 * @className: EnvController
 * @description: TODO push前删除这个TODO,并添加对应注释,如果liangxuekai忘了,拉出去弹小丁丁
 * @author: liangxuekai
 * @createDate: 2019-06-17 17:12
 * @updateUser: liangxuekai
 * @updateDate: 2019-06-17 17:12
 * @updateRemark: 修改内容
 * @version: 1.0
 */
@RestController
public class EnvController {

    private final Environment environment;

    @Autowired
    public EnvController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/demo/env/{name}")
    public String environment(@PathVariable String name){
        return environment.getProperty(name);
    }
}
