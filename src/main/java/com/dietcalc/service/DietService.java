package com.dietcalc.service;

import com.dietcalc.dto.DietRequestDTO;
import com.dietcalc.dto.DietResponseDTO;
import com.dietcalc.entity.Diet;
import com.dietcalc.entity.Person;

public interface DietService {

    DietResponseDTO calculateDiet(DietRequestDTO dietRequest);

    Diet findByPerson(Person person);

    DietResponseDTO findByPersonByDto();
}
