package com.homework01.homework01.controller;

import com.homework01.homework01.person.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("박응수");
        person.setAddress("서울");
        person.setAge(30);
        person.setJob("항해99 선원");
        return person;
    }
}