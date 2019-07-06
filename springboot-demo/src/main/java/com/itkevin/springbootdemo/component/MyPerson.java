package com.itkevin.springbootdemo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author kevin
 * 自有非application配置
 */
@Component
@PropertySource("classpath:/myConfig/myConfig.properties")
@ConfigurationProperties(prefix = "girl")
public class MyPerson {
    private String name;
    private int age;
    private boolean marraied;

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", marraied=" + marraied +
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

    public boolean isMarraied() {
        return marraied;
    }

    public void setMarraied(boolean marraied) {
        this.marraied = marraied;
    }
}
