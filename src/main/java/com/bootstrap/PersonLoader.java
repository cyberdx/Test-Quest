package com.bootstrap;

import com.domain.Person;
import com.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class PersonLoader implements ApplicationListener<ContextRefreshedEvent> {
    private PersonRepository personDemographicsRepository ;

    @Autowired
    public void setProductRepository(PersonRepository personDemographicsRepository) {
        this.personDemographicsRepository = personDemographicsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Person person = new Person();
        person.setName("Test Person 1");
        person.setDateOfBirth("01/01/1980");
        person.setPpsNumber("1234567T");
        person.setPhone("0861234567");
//        personDemographicsRepository.save(person);
    }
}
