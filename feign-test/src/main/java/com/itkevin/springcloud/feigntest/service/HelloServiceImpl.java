package com.itkevin.springcloud.feigntest.service;

import com.itkevin.springcloud.po.Person;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: kevin-springboot
 * @Package: com.itkevin.springcloud.feigntest.service
 * @ClassName: HelloServiceImpl
 * @Description:
 * @Author: Kevin
 * @CreateDate: 18/11/7 下午1:59
 * @UpdateUser:
 * @UpdateDate: 18/11/7 下午1:59
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public Person getPerson(Person person) {
        person.setAge(81);
        person.setName("默认");
        return person;
    }
}
