package com.dbtest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbtest.entity.Person;
import com.dbtest.repository.PersonRepository;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonRepository personRepository;

    @GetMapping("/test")
    @CrossOrigin(origins = "http://localhost:3000")
    public String test()
    {
        return "Message received...mari";
    }


    @PostMapping("/create")
    @CrossOrigin(origins = "http://localhost:3000")
    public Person save(@RequestBody Person person) {

        try {
            return personRepository.save(person);
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return null;
        }

    }

    @PutMapping("/{id}")
    public String update(@PathVariable(value = "id") String id, @RequestBody Person person) {
        return personRepository.update(id, person);

    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Person> findAll() {

        List<Person> persons =  personRepository.findAll();
        return persons;
 
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable(value = "id") String id) {

        return personRepository.findById(id);
    }

}