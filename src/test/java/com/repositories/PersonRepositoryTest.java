package com.repositories;

import com.configuration.RepositoryConfiguration;
import com.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class PersonRepositoryTest {

    private PersonRepository personRepository;

    @Autowired
    public void setProductRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    public void testDb(){
        Person person = new Person();
        person.setName("tester");
        person.setPpsNumber("001TEST");
        person.setDateOfBirth("01/01/1919");
        person.setPhone("0899944654");

        personRepository.save(person);
        assertNotNull(person.getPpsNumber());

        Person dbPerson = personRepository.findOne(person.getPpsNumber());
        assertNotNull(dbPerson);

        assertEquals(person.getPpsNumber(), dbPerson.getPpsNumber());
        assertEquals(person.getName(), dbPerson.getName());

        long personCount = personRepository.count();
        assertEquals(personCount, 1);

        Iterable<Person> products = personRepository.findAll();

        int count = 0;

        for(Person p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}