package com.itkevin.springbootdemo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @projectName: kevin-springboot
 * @className: InvalidInitExampleBean
 * @description: TODO push前删除这个TODO,并添加对应注释,如果liangxuekai忘了,拉出去弹小丁丁
 * @author: liangxuekai
 * @createDate: 2019-07-12 13:54
 * @updateUser: liangxuekai
 * @updateDate: 2019-07-12 13:54
 * @updateRemark: 修改内容
 * @version: 1.0
 */
@Component
public class InvalidInitExampleBean {
    @Autowired
    private Environment environment;

//    @PostConstruct
    public void InvalidInitExampleBean() {
        //此处大概率会出现空指针导致Spring容器初始化异常
        environment.getActiveProfiles();
    }

    public String nullTest(){
        return environment.toString();
    }
}
