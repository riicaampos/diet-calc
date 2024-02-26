package com.dietcalc.service.impl;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.entity.Person;
import com.dietcalc.entity.User;
import com.dietcalc.repository.PersonRepository;
import com.dietcalc.service.PersonService;
import com.dietcalc.service.UserService;
import com.dietcalc.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Override
    public void createPerson(PersonRequestDTO person) {

        Person p = modelMapper.map(person, Person.class);
        p.setUser(this.userService.getByContext());

        this.personRepository.save(p);
    }

    @Override
    public void updatePerson(PersonRequestDTO personRequest) {

        User loggedUser = this.userService.getByContext();
        Person person = this.personRepository.findByUser(loggedUser);

        person = Utils.castPersonDtoToPerson(personRequest, person);
        this.personRepository.save(person);

    }

    @Override
    public Person getPersonByUser() {
        User user = this.userService.getByContext();
        return this.personRepository.findByUser(user);
    }

    @Override
    public Double setFatFreeWeigth(Double fatPercent) {
        User user = this.userService.getByContext();
        Person person = this.personRepository.findByUser(user);

        person.setFatPercent(fatPercent);
        person.setFatFreeWeight(Utils.calculateFatFreeWeight(fatPercent, person.getWeight()));

        this.personRepository.save(person);

        return person.getFatFreeWeight();
    }

    @Override
    public void savePerson(Person person) {
        this.personRepository.save(person);
    }
}
