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
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    private final UserService userService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void createPerson(PersonRequestDTO person) {
        String personJson = "";
        try{
            person.setUserId(this.userService.getByContext().getId());
            personJson = objectMapper.writeValueAsString(person);
        }catch(Exception e){
            log.error(e.getMessage());
        }
        log.info("Enviando pessoa para a fila..."+personJson);
        kafkaTemplate.send("person", personJson);
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

    @KafkaListener(topicPartitions
            = @TopicPartition(topic = "person", partitions = { "0", "1" }))
    public void listenToPersonTopic(@Payload String personJson) {
        log.info("recuperando e salvando pessoa....");
        try{
            Person person = objectMapper.readValue(personJson, Person.class);
            person.setUser(this.userService.findById(person.getUserId()));
            this.personRepository.save(person);
        }catch(Exception e){
            log.info("erro"+e.getMessage());
            e.printStackTrace();
        }
    }
}
