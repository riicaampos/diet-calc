package com.dietcalc.service.impl;

import com.dietcalc.dto.DietRequestDTO;
import com.dietcalc.dto.DietResponseDTO;
import com.dietcalc.entity.Person;
import com.dietcalc.service.DietService;
import com.dietcalc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final PersonService personService;


    @Override
    public void calculateDiet(DietRequestDTO dietRequest) {

        Person person = this.personService.getPersonByUser();
        Double personWeight = person.getWeight();;

        DietResponseDTO dietResponse = new DietResponseDTO();

        dietResponse.setPercProtein(dietRequest.getPercProtein());


    }
}
