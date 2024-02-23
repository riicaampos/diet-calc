package com.dietcalc.service.impl;

import com.dietcalc.entity.Person;
import com.dietcalc.enums.Equations;
import com.dietcalc.enums.Sex;
import com.dietcalc.service.CalculateMetabolicRateService;
import com.dietcalc.service.PersonService;
import com.dietcalc.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculateMetabolicRateServiceImpl implements CalculateMetabolicRateService {

    private final PersonService personService;

    @Override
    public Double calculateMetabolicRate(Equations equations, Double fatPercent, Double physicalActivityFactor, Double calorieDeficit) {

        Person person = this.personService.getPersonByUser();
        Double metabolicRate = 0.0;

        Integer age = Utils.calculateAgeBetweenDates(person.getBirthDate());

        switch (equations) {

            case FAOOMS:

                if (person.getSex().equals(Sex.MALE)) {
                    if (age >= 10 && age <= 18) {
                        metabolicRate = (17.686 * person.getWeight()) + 658.2;
                    } else if (age >= 18 && age <= 30) {
                        metabolicRate = (15.057 * person.getWeight()) + 692.2;
                    } else if (age >= 30 && age <= 60) {
                        metabolicRate = (11.472 * person.getWeight()) + 873.1;
                    } else {
                        metabolicRate = (11.711 * person.getWeight()) + 587.7;
                    }
                } else {
                    if (age >= 10 && age <= 18) {
                        metabolicRate = (13.384 * person.getWeight()) + 692.6;
                    } else if (age >= 18 && age <= 30) {
                        metabolicRate = (14.818 * person.getWeight()) + 486.6;
                    } else if (age >= 30 && age <= 60) {
                        metabolicRate = (8.126 * person.getWeight()) + 845.6;
                    } else {
                        metabolicRate = (9.082 * person.getWeight()) + 658.5;
                    }
                }

                if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
                    metabolicRate = metabolicRate * physicalActivityFactor;

                if (calorieDeficit != null && calorieDeficit > 0.0)
                    metabolicRate = metabolicRate - calorieDeficit;

                person.setMetabolicRate(metabolicRate);
                this.personService.savePerson(person);

                return metabolicRate;

            case MIFFLINSTJEOR:

                if (person.getSex().equals(Sex.MALE)) {
                    metabolicRate = (10 * person.getWeight()) + (6.25 * person.getHeight()) - (5.0 * age) + 5;
                } else {
                    metabolicRate = (10 * person.getWeight()) + (6.25 * person.getHeight()) - (5.0 * age) - 161;
                }

                if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
                    metabolicRate = metabolicRate * physicalActivityFactor;

                if (calorieDeficit != null && calorieDeficit > 0.0)
                    metabolicRate = metabolicRate - calorieDeficit;

                person.setMetabolicRate(metabolicRate);
                this.personService.savePerson(person);

                return metabolicRate;

            case CUNNIGHAMDTINSLEY:

                /**
                 * Implementar uma excessão caso o percentual de gordura nao seja passado
                 * ou seja igual a zero, pois nessa equação é obrigatorio..
                 */

                Double freeFatWeight = Utils.calculateFatFreeWeight(fatPercent, person.getWeight());

                metabolicRate = (22 * freeFatWeight) + 500;

                if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
                    metabolicRate = metabolicRate * physicalActivityFactor;

                if (calorieDeficit != null && calorieDeficit > 0.0)
                    metabolicRate = metabolicRate - calorieDeficit;

                person.setMetabolicRate(metabolicRate);
                person.setFatPercent(fatPercent);
                person.setFatFreeWeight(freeFatWeight);

                this.personService.savePerson(person);

                return metabolicRate;

            case HARRISANDBENEDICT:
                if (person.getSex().equals(Sex.MALE)) {
                    metabolicRate = 66 + (13.8 * person.getWeight()) + (5.0 * person.getHeight()) - (6.8 * age);
                } else {
                    metabolicRate = 655 + (9.6 * person.getWeight()) + (1.9 * person.getHeight()) - (4.7 * age);
                }

                if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
                    metabolicRate = metabolicRate * physicalActivityFactor;

                if (calorieDeficit != null && calorieDeficit > 0.0)
                    metabolicRate = metabolicRate - calorieDeficit;

                person.setMetabolicRate(metabolicRate);
                this.personService.savePerson(person);

                return metabolicRate;
            default:
                return 0.0;

        }
    }
}
