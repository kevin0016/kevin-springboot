package com.itkevin.springcloud.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: kevin-springboot
 * @Package: com.itkevin.springcloud.consumer.service
 * @ClassName: ConsumerServiceImpl
 * @Description:
 * @Author: Kevin
 * @CreateDate: 18/11/6 下午4:34
 * @UpdateUser:
 * @UpdateDate: 18/11/6 下午4:34
 * @UpdateRemark:
 * @Version: 1.0
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getstr() {
        String url = "http://hello-service/hello";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity.getBody();
    }
}
