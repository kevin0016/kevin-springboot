package com.itkevin.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: kevin-springboot
 * @className: CserviceImpl
 * @description: TODO push前删除这个TODO,并添加对应注释,如果liangxuekai忘了,拉出去弹小丁丁
 * @author: liangxuekai
 * @createDate: 2019-07-12 13:39
 * @updateUser: liangxuekai
 * @updateDate: 2019-07-12 13:39
 * @updateRemark: 修改内容
 * @version: 1.0
 */
@Service
public class CserviceImpl implements Cservice {

    @Autowired
    private Aservice aservice;

    @Override
    public String testDemo() {
        return "测试循环调用的逻辑";
//        return  aservice.testDemo();
    }


    public String test1(){
       return  aservice.testDemo();
    }
}
