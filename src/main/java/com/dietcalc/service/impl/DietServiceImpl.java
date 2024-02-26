package com.dietcalc.service.impl;

import com.dietcalc.dto.DietRequestDTO;
import com.dietcalc.dto.DietResponseDTO;
import com.dietcalc.entity.Person;
import com.dietcalc.exceptions.BadRequestException;
import com.dietcalc.service.DietService;
import com.dietcalc.service.PersonService;
import com.dietcalc.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final PersonService personService;


    @Override
    public void calculateDiet(DietRequestDTO dietRequest) {

        if(dietRequest.getPercProtein()+ dietRequest.getPercCarb()+ dietRequest.getPercFat() > 100)
            throw new BadRequestException(Utils.getMessage("exception.total.greater100"));



    }
}
