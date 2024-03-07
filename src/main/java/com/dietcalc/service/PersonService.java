package com.dietcalc.service;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.entity.Person;
import com.dietcalc.entity.User;
import com.dietcalc.repository.PersonRepository;
import com.dietcalc.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public void createPerson(PersonRequestDTO person) {

        Person p = modelMapper.map(person, Person.class);
        p.setUser(this.userService.getByContext());

        this.personRepository.save(p);
    }

    public void updatePerson(PersonRequestDTO personRequest) {

        User loggedUser = this.userService.getByContext();
        Person person = this.personRepository.findByUser(loggedUser);

        person = Utils.castPersonDtoToPerson(personRequest, person);
        this.personRepository.save(person);

    }

    public Person getPersonByUser() {
        User user = this.userService.getByContext();
        return this.personRepository.findByUser(user);
    }

    public Double setFatFreeWeigth(Double fatPercent) {
        User user = this.userService.getByContext();
        Person person = this.personRepository.findByUser(user);

        person.setFatPercent(fatPercent);
        person.setFatFreeWeight(Utils.calculateFatFreeWeight(fatPercent, person.getWeight()));

        this.personRepository.save(person);

        return person.getFatFreeWeight();
    }

    public void savePerson(Person person) {
        this.personRepository.save(person);
    }
}
