package com.itkevin.springcloud.feigntest.controller;

import com.itkevin.springcloud.feigntest.service.HelloService;
import com.itkevin.springcloud.po.Person;
import com.itkevin.springcloud.utils.JsonHelper;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



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
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/feign-consumer",method = RequestMethod.GET)
    public String index(){

        return helloService.hello();
    }
    @RequestMapping(value = "/feign-consumer-getPerson",method = RequestMethod.POST)
    public String getPerson(Person person){
        return JsonHelper.toJson(helloService.getPerson(person));
    }

}
