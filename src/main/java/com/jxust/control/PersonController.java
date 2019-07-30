package com.jxust.control;


import com.jxust.dao.PersonRepository;
import com.jxust.entity.Person;
import com.jxust.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PersonController {

//    @GetMapping(value = "/girls")
//    @PostMapping(value = "/girls")
//    @PutMapping(value = "/girls/{id}")
//    @DeleteMapping(value = "/girls/{id}")

    @Autowired(required = false)
    PersonRepository personRepository;

    @GetMapping(value = "/person")
    private List<Person> personList() {
        List<Person> all = personRepository.findAll();
        for (int j = 0; j<all.size(); j++){
            System.out.println(all.get(j).getName());
            System.out.println(all.get(j).getAge());
            System.out.println(all.get(j).getId());
        }
        return personRepository.findAll();
    }

    @PostMapping(value = "/person")
    public Person personAdd(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        System.out.println("---->>" + person.getName());
        System.out.println("---->>" + person.getAge());
        return personRepository.save(person);
    }

    @GetMapping(value = "/person2/{id}")
    public Optional<Person> personFindOne(@PathVariable("id") Integer id) {

        Optional<Person> person = personRepository.findById(id);
        System.out.println(person.get().getName());
        System.out.println(person.get().getAge());
        System.out.println("---->>" + id);
        System.out.println();
        Integer age = person.get().getAge();
        return personRepository.findById(id);
    }

    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    @GetMapping(value = "/person/age/{age}")
    public List<Person> personListByAge(@PathVariable("age") Integer age) {
        List<Person> byAge = personRepository.findByAge(age);

        System.out.println(byAge.get(0).getName());
        return personRepository.findByAge(age);
    }

    @GetMapping(value = "/person/age/{age1}/{age2}")
    public List<Person> personListByAge(@PathVariable("age1") Integer age1,@PathVariable("age2") Integer age2) {
        System.out.println(age1);
        System.out.println("age2:   "+age2);
        List<Person> byAge = personRepository.findByPriceRange(12,15);
        System.out.println(byAge.get(0).getId());
        return personRepository.findByPriceRange(12,15);  //找出年龄大于12小于15的   即13,14的
    }


    @Autowired
    private PersonService personService;
    /**
     * 事务测试
     */
    @PostMapping("/person/two")
    public void personTwo(){
        personService.insertTwo();
    }

}
