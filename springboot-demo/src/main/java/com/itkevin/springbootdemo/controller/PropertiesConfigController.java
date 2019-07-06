package com.itkevin.springbootdemo.controller;

import com.itkevin.springbootdemo.component.MyPerson;
import com.itkevin.springbootdemo.component.Person1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 */
@RestController
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
    public Person1 getPerson1(){
        LOGGER.debug("=========================================");
        LOGGER.debug(person1.toString());
        LOGGER.debug("=========================================");
        LOGGER.debug(myPerson.toString());
        LOGGER.debug("=========================================");
        return person1;
    }
}
