package com.itkevin.springcloud.eurekaclient.controller;

import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ProjectName: springcloud-eureka-service
 * @Package: com.itkevin.springcloudeurekaservice.controller
 * @ClassName: helloController
 * @Description:
 * @Author: Kevin
 * @CreateDate: 18/11/6 下午3:10
 * @UpdateUser:
 * @UpdateDate: 18/11/6 下午3:10
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
public class helloController {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    DiscoveryClient client;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        List<ServiceInstance> instances = client.getInstances("localhost");
        logger.info("host is"+instances);
        return "hello world";
    }

}