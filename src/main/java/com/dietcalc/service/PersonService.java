package com.dietcalc.service;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.entity.Person;

public interface PersonService {

    void createPerson(PersonRequestDTO person);

    void updatePerson(PersonRequestDTO person);

    Person getPersonByUser();

    Double setFatFreeWeigth(Double fatPercent);

    void savePerson(Person person);
}
