package com.dietcalc.service.impl;

import com.dietcalc.dto.DietRequestDTO;
import com.dietcalc.dto.DietResponseDTO;
import com.dietcalc.entity.Diet;
import com.dietcalc.entity.Person;
import com.dietcalc.repository.DietRepository;
import com.dietcalc.service.DietService;
import com.dietcalc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final PersonService personService;
    private final DietRepository dietRepository;


    @Override
    public DietResponseDTO calculateDiet(DietRequestDTO dietRequest) {

        Person person = this.personService.getPersonByUser();
        DietResponseDTO response = new DietResponseDTO();

        response.getProtein().setQntProteinGr(person.getWeight() * dietRequest.getGrPerKgProt());
        response.getProtein().setCalProtein(response.getProtein().getQntProteinGr()*4);
        response.getProtein().setPercProtein((response.getProtein().getCalProtein()/ person.getMetabolicRate())*100);
        response.getProtein().setQntProteinGrKgBody(dietRequest.getGrPerKgProt());

        response.getCarbohydrate().setCalCarb((person.getMetabolicRate() * dietRequest.getPercCarb())/100);
        response.getCarbohydrate().setQntCarbGr(response.getCarbohydrate().getCalCarb()/4);
        response.getCarbohydrate().setPercCarb(dietRequest.getPercCarb());
        response.getCarbohydrate().setQntCarbGrKgBody(response.getCarbohydrate().getQntCarbGr()/ person.getWeight());

        response.getFat().setPercFat(dietRequest.getPercFat());
        response.getFat().setCalFat((person.getMetabolicRate()*response.getFat().getPercFat())/100);
        response.getFat().setQntFatGr(response.getFat().getCalFat()/9);
        response.getFat().setQntFatGrKgBody(response.getFat().getQntFatGr()/ person.getWeight());
        response.setNumberOfMeals(dietRequest.getNumberOfMeals());

        response.setMetabolicRate(person.getMetabolicRate());

        this.calculatePerMeal(response);

        this.dietRepository.save(new Diet(response, person));

        return response;
    }

    @Override
    public Diet findByPerson(Person person) {
        return this.dietRepository.findByPerson(person);
    }

    @Override
    public DietResponseDTO findByPersonByDto() {
        Person person = this.personService.getPersonByUser();
        return new DietResponseDTO(this.findByPerson(person), person);
    }

    public void calculatePerMeal(DietResponseDTO responseDTO){

        responseDTO.getProteinPerMeal().setQntProteinGr(responseDTO.getProtein().getQntProteinGr() / responseDTO.getNumberOfMeals());
        responseDTO.getProteinPerMeal().setCalProtein(responseDTO.getProtein().getCalProtein() / responseDTO.getNumberOfMeals());

        responseDTO.getCarbohydratePerMeal().setQntCarbGr(responseDTO.getCarbohydrate().getQntCarbGr() / responseDTO.getNumberOfMeals());
        responseDTO.getCarbohydratePerMeal().setCalCarb(responseDTO.getCarbohydrate().getCalCarb() / responseDTO.getNumberOfMeals());

        responseDTO.getFatPerMeal().setQntFatGr(responseDTO.getFat().getQntFatGr() / responseDTO.getNumberOfMeals());
        responseDTO.getFatPerMeal().setCalFat(responseDTO.getFat().getCalFat() / responseDTO.getNumberOfMeals());

    }

}
