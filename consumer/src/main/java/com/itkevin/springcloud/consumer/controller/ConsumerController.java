package com.itkevin.springcloud.consumer.controller;

import com.itkevin.springcloud.consumer.service.ConsumerService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: kevin-springboot
 * @Package: com.itkevin.springcloud.consumer.controller
 * @ClassName: ConsumerController
 * @Description:
 * @Author: Kevin
 * @CreateDate: 18/11/6 下午4:32
 * @UpdateUser:
 * @UpdateDate: 18/11/6 下午4:32
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return consumerService.getstr();
    }
}
