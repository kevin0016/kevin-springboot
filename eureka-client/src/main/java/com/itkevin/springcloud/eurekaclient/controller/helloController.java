package com.itkevin.springcloud.eurekaclient.controller;

import com.itkevin.springcloud.po.Person;
import com.itkevin.springcloud.utils.JsonHelper;
import com.sun.istack.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        try {
            logger.info("get " );
            List<ServiceInstance> instances = client.getInstances("host");
//            Thread.sleep(10000);
            logger.info("host is" + instances);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hello world";
    }
    @RequestMapping(value = "/getPerson", method = RequestMethod.POST)
    public Person getPerson(@RequestBody Person person) {
        try {
            List<ServiceInstance> instances = client.getInstances("localhost");
//            Thread.sleep(10000);
            logger.info("host is" + instances);
        } catch (Exception e) {
            e.printStackTrace();
        }
        person.setName("kevin");
        person.setAge(18);
        logger.info("person is: "+JsonHelper.toJson(person));
        return person;
    }

}
