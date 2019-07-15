package com.itkevin.springbootdemo.po;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @projectName: kevin-springboot
 * @className: demo1
 * @description: TODO push前删除这个TODO,并添加对应注释,如果liangxuekai忘了,拉出去弹小丁丁
 * @author: liangxuekai
 * @createDate: 2019-07-12 14:08
 * @updateUser: liangxuekai
 * @updateDate: 2019-07-12 14:08
 * @updateRemark: 修改内容
 * @version: 1.0
 */
@Component
public class Demo1 {

    @Autowired
    private Demo2 demo2;

}
