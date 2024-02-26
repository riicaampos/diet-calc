package com.dietcalc.controller;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping()
    public void createPerson(@RequestBody PersonRequestDTO person) {
        this.personService.createPerson(person);
    }


    @PutMapping()
    public void updatePerson(@RequestBody PersonRequestDTO person){
        this.personService.updatePerson(person);
    }

}
