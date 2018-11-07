package com.itkevin.springcloud.po;

/**
 * @ProjectName: kevin-springboot
 * @Package: com.itkevin.springcloud.po
 * @ClassName: Person
 * @Description:
 * @Author: Kevin
 * @CreateDate: 18/11/7 上午10:34
 * @UpdateUser:
 * @UpdateDate: 18/11/7 上午10:34
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
