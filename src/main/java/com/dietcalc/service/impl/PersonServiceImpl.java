package com.dietcalc.service.impl;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.entity.Person;
import com.dietcalc.entity.User;
import com.dietcalc.repository.PersonRepository;
import com.dietcalc.service.PersonService;
import com.dietcalc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    public Person getPersonByUser() {
        User user = this.userService.getByContext();
        return this.personRepository.findByUser(user);
    }

    @Override
    public void savePerson(Person person) {
      this.personRepository.save(person);
    }
}
