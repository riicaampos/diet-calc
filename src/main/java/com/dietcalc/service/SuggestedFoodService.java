package com.dietcalc.service;

import com.dietcalc.dto.SuggestedFoodRequestDTO;
import com.dietcalc.entity.NutritionalTable;
import com.dietcalc.entity.Person;
import com.dietcalc.entity.SuggestedFood;
import com.dietcalc.enums.SuggestedFoodStatus;
import com.dietcalc.exceptions.BadRequestException;
import com.dietcalc.repository.SuggestedFoodRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuggestedFoodService {

    private final SuggestedFoodRespository suggestedFoodRespository;
    private final ModelMapper modelMapper;
    private final PersonService personService;
    private final NutritionalTableService nutritionalTableService;

    public void saveSuggestion(SuggestedFoodRequestDTO request){
        Person person = this.personService.getPersonByUser();

        SuggestedFood newSuggestion = modelMapper.map(request, SuggestedFood.class);
        newSuggestion.setStatus(SuggestedFoodStatus.WAITING);
        newSuggestion.setPerson(person);

        this.suggestedFoodRespository.save(newSuggestion);
    }

    public void approveSuggestion(Long suggestionId){
        SuggestedFood suggestedFood = this.suggestedFoodRespository.findById(suggestionId).orElse(null);

        if(suggestedFood == null)
            throw new BadRequestException("Não foi encontrada a sugestão");

        NutritionalTable nutritionalTable = modelMapper.map(suggestedFood, NutritionalTable.class);

        try {
            this.nutritionalTableService.saveFood(nutritionalTable);
        }catch (Exception e){
            log.error("erro ao salvar sugestão: "+e.getMessage());
        }

        suggestedFood.setStatus(SuggestedFoodStatus.APPROVED);
        this.suggestedFoodRespository.save(suggestedFood);

    }
}
