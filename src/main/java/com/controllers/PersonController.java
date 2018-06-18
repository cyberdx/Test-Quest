package com.controllers;

import com.domain.Person;
import com.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.Serializable;

@Controller
public class PersonController implements Serializable {
    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("persons", personService.listOfAllPersons());
        return "persons";
    }

    @RequestMapping("person/new")
    public String newperson(Model model){
        model.addAttribute("person", new Person());
        return "personform";
    }

    @PostMapping("/person")
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "personform";
        }
        if (person.getPpsNumber().equals("")){
            bindingResult.reject("name", "ErrorWER message");
            return "personform";
        }

        personService.savePerson(person);
        return "redirect:/persons";
    }
}
