package com.dietcalc.service;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.entity.Person;
import com.dietcalc.entity.User;
import com.dietcalc.repository.PersonRepository;
import com.dietcalc.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    private final UserService userService;

    public void createPerson(PersonRequestDTO personDTO) {
       Person person = modelMapper.map(personDTO, Person.class);
       User loggedUser = this.userService.getByContext();
       person.setUser(loggedUser);
       this.personRepository.save(person);
    }

    public Person updatePerson(PersonRequestDTO personRequest) {

        User loggedUser = this.userService.getByContext();
        Person person = this.personRepository.findByUser(loggedUser);

        person = Utils.castPersonDtoToPerson(personRequest, person);
        return this.personRepository.save(person);

    }

    public Person updatePerson(PersonRequestDTO personRequest, User loggedUser) {
        Person person = this.personRepository.findByUser(loggedUser);

        person = Utils.castPersonDtoToPerson(personRequest, person);
        return this.personRepository.save(person);
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

    public Person savePerson(Person person) {
        return this.personRepository.save(person);
    }


    public List<Person> getAllPersons(){
        return this.personRepository.findAll();
    }

    public Person findById(Long id){
        return this.personRepository.findById(id).orElse(null);
    }
}
