package com.itkevin.springbootdemo.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.itkevin.springbootdemo.component.MyPerson;
import com.itkevin.springbootdemo.component.Person1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 */
@RestController
@Api(tags = "1.1",description = "获取自定义配置属性",value = "用户")
public class PropertiesConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesConfigController.class);

    private Person1 person1;

    private MyPerson myPerson;

    @Autowired
    public PropertiesConfigController(Person1 person1, MyPerson myPerson) {
        this.person1 = person1;
        this.myPerson = myPerson;
    }



    @GetMapping("/person")
    @ApiOperation(value = "获取person对象")
    public Person1 getPerson1(){
        LOGGER.debug("=========================================");
        LOGGER.debug(person1.toString());
        LOGGER.debug("=========================================");
        LOGGER.debug(myPerson.toString());
        LOGGER.debug("=========================================");
        return person1;
    }



    @GetMapping("/person/{name}")
    @ApiOperation(value = "获取person对象")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",value = "用户名称",dataType = ApiDataType.STRING,paramType = ApiParamType.PATH)})
    public Person1 getPerson2(@PathVariable String name){
        person1.setName(name);
        return person1;
    }
}
