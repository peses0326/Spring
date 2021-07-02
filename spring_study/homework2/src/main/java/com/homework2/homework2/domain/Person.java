package com.homework2.homework2.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Person extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;


    public Person(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.job = requestDto.getJob();
        this.age = requestDto.getAge();
        this.address = requestDto.getAddress();
    }
    public Person(String name, String job, int age, String address) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.address = address;
    }

    public void update(PersonRequestDto requestDto) {
        this.name = requestDto.getName();
        this.job = requestDto.getJob();
        this.age = requestDto.getAge();
        this.address = requestDto.getAddress();
    }

}