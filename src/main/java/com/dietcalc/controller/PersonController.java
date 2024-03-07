package com.dietcalc.controller;

import com.dietcalc.dto.PersonRequestDTO;
import com.dietcalc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping()
    public ResponseEntity<Void> createPerson(@RequestBody PersonRequestDTO person) {
        this.personService.createPerson(person);
        return ResponseEntity.ok().build();
    }


    @PutMapping()
    public ResponseEntity<Void> updatePerson(@RequestBody PersonRequestDTO person){
        this.personService.updatePerson(person);
        return ResponseEntity.ok().build();
    }

}
