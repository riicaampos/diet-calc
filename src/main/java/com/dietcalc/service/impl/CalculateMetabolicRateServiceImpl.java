package com.dietcalc.service.impl;

import com.dietcalc.entity.Person;
import com.dietcalc.enums.Equations;
import com.dietcalc.exceptions.BadRequestException;
import com.dietcalc.service.CalculateMetabolicRateService;
import com.dietcalc.service.PersonService;
import com.dietcalc.utils.CalculateEquations;
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

                metabolicRate = CalculateEquations.calculateFaoOms(person, age, fatPercent, physicalActivityFactor, calorieDeficit);

                person.setMetabolicRate(metabolicRate);
                this.personService.savePerson(person);

                return metabolicRate;

            case MIFFLINSTJEOR:

                metabolicRate = CalculateEquations.calculateMifflinstjeor(person, age, physicalActivityFactor, calorieDeficit);

                person.setMetabolicRate(metabolicRate);
                this.personService.savePerson(person);

                return metabolicRate;

            case CUNNIGHAMDTINSLEY:

                if(fatPercent == null)
                    throw new BadRequestException(Utils.getMessage("excption.fatpercent.isnull"));

                Double freeFatWeight = Utils.calculateFatFreeWeight(fatPercent, person.getWeight());

                metabolicRate = CalculateEquations.calculateCunnighAndTinsley(freeFatWeight, physicalActivityFactor, calorieDeficit);

                person.setMetabolicRate(metabolicRate);
                person.setFatPercent(fatPercent);
                person.setFatFreeWeight(freeFatWeight);

                this.personService.savePerson(person);

                return metabolicRate;

            case HARRISANDBENEDICT:

                metabolicRate = CalculateEquations.calculateHarrisAndBenedict(person, age, physicalActivityFactor, calorieDeficit);

                person.setMetabolicRate(metabolicRate);
                this.personService.savePerson(person);

                return metabolicRate;
            default:
                return 0.0;

        }
    }
}
