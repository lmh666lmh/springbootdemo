package com.jxust.control;

import com.jxust.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
   /* @Value("${name}")
    private String name;
    @Value("${age}")
    private String age;

    @Autowired
    private PersonProperties personProperties;

    @GetMapping("/hello")
    public String say(){
        System.out.println(name);
        System.out.println(age);
        return personProperties.getName()+"  "+personProperties.getAge();
    }*/




}
