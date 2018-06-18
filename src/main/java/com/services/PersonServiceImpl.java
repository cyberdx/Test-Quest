package com.services;

import com.domain.Person;
import com.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Autowired
    public void setProductRepository(PersonRepository personDemographicsRepository) {
        this.personRepository = personDemographicsRepository;
    }

    @Override
    public Iterable<Person> listOfAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(String ppsNumber) {
        return personRepository.findOne(ppsNumber);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
