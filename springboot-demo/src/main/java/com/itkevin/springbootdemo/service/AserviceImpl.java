package com.itkevin.springbootdemo.service;

import com.itkevin.springbootdemo.SpringbootDemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @projectName: kevin-springboot
 * @className: AserviceImpl
 * @description: TODO push前删除这个TODO,并添加对应注释,如果liangxuekai忘了,拉出去弹小丁丁
 * @author: liangxuekai
 * @createDate: 2019-07-12 13:39
 * @updateUser: liangxuekai
 * @updateDate: 2019-07-12 13:39
 * @updateRemark: 修改内容
 * @version: 1.0
 */
@Service
public class AserviceImpl implements Aservice {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootDemoApplication.class);

    @Autowired
    private Bservice bservice;

    @Autowired
    private Environment environment;


    @Override
    public String testDemo(){
        LOGGER.error(environment.toString());
        return bservice.testDemo();
    }
}
