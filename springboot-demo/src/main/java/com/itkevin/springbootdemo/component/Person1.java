package com.itkevin.springbootdemo.component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author kevin
 */
@Component
@ConfigurationProperties(prefix = "person")
@ApiModel
public class Person1 implements Serializable {

    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户年龄")
    private int age;

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
