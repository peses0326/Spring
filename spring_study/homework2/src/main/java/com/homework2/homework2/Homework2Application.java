package com.homework2.homework2;

import com.homework2.homework2.domain.Person;
import com.homework2.homework2.domain.PersonRepository;
import com.homework2.homework2.domain.PersonRequestDto;
import com.homework2.homework2.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Homework2Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(new Person("엉덩이", "스프링 개발자", 25, "허리 아래"));

            System.out.println("데이터 인쇄");
            List<Person> personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getJob());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
            }

            PersonRequestDto requestDto = new PersonRequestDto("정수리", "노드 개발자", 26, "머리 꼭대기");
            personService.update(1L, requestDto);
            personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getJob());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
            }
        };
    }
}