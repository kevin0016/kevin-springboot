package com.itkevin.springcloud.feigntest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: kevin-springboot
 * @Package: com.itkevin.springcloud.feigntest.service
 * @ClassName: HelloService
 * @Description:
 * @Author: Kevin
 * @CreateDate: 18/11/6 下午6:59
 * @UpdateUser:
 * @UpdateDate: 18/11/6 下午6:59
 * @UpdateRemark:
 * @Version: 1.0
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
