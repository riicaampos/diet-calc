package com.dietcalc.service.impl;

import com.dietcalc.entity.Person;
import com.dietcalc.enums.Equations;
import com.dietcalc.enums.Sex;
import com.dietcalc.service.CalculateMetabolicRateService;
import com.dietcalc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class CalculateMetabolicRateServiceImpl implements CalculateMetabolicRateService {

    private final PersonService personService;
    @Override
    public Double calculateMetabolicRate(Equations equations) {

        Person person = this.personService.getPersonByUser();
        Double metabolicRate = 0.0;
        LocalDate nowDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(person.getBirthDate().getYear(), person.getBirthDate().getMonth(), person.getBirthDate().getDay());

        //calculo da idade errado corrigir
        Integer age = Period.between(nowDate, birthDate).getYears();

        switch (equations){

            case FAOOMS:

            return 0.0;

            case MIFFLINSTJEOR:
                return 0.0;

            case CUNNIGHAMDTINSLEY:
                return 0.0;

            case HARRISANDBENEDICT:
                System.out.println(age);
                if(person.getSex().equals(Sex.MALE)){
                    metabolicRate = 66+(13.8* person.getWeight()) + (5.0 * person.getHeight()) - (6.8 * age);
                }else{
                    metabolicRate = 655 + (9.6 * person.getWeight()) + (1.9 * person.getHeight()) - (4.7 * age);
                }

                person.setMetabolicRate(metabolicRate);
                this.personService.savePerson(person);

                return metabolicRate;
            default:
                return 0.0;

        }
    }
}
