package com.services;


import com.domain.Person;

public interface PersonService {
    Iterable<Person> listOfAllPersons();
    Person getPerson(String ppsNumber);
    Person savePerson(Person person);
}
