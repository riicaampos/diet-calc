package com.dietcalc.service;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.entity.Person;
import com.dietcalc.entity.User;

public interface PersonService {

    void createPerson(PersonRequestDTO person);

    Person getPersonByUser();

    void savePerson(Person person);
}
