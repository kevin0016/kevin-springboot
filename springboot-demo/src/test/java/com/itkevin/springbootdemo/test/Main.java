package com.itkevin.springbootdemo.test;

import com.itkevin.springbootdemo.test.po.Apo;
import org.junit.Test;

/**
 * @projectName: kevin-springboot
 * @className: Main
 * @description: TODO push前删除这个TODO,并添加对应注释,如果liangxuekai忘了,拉出去弹小丁丁
 * @author: liangxuekai
 * @createDate: 2019-07-12 14:01
 * @updateUser: liangxuekai
 * @updateDate: 2019-07-12 14:01
 * @updateRemark: 修改内容
 * @version: 1.0
 */
public class Main {


    @Test
    public void demo() {
        Apo apo = new Apo();
        System.out.println(apo.toString());
    }
}
