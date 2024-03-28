package com.dietcalc.utils;

import com.dietcalc.entity.Person;
import com.dietcalc.enums.Sex;

public class CalculateEquations {

    public static Double calculateFaoOms(Person person, Integer age, Double physicalActivityFactor, Double calorieDeficit){

        Double metabolicRate;

        switch (person.getSex()){
            case MALE -> metabolicRate = getFaoOmsMale(person, age,physicalActivityFactor, calorieDeficit);
            case FEMALE -> metabolicRate = getFaoOmsFemale(person, age,physicalActivityFactor, calorieDeficit);
            default -> metabolicRate = 0.0;
        }

        if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
            metabolicRate = getPhysicalActivityFactor(metabolicRate, physicalActivityFactor);

        if (calorieDeficit != null && calorieDeficit > 0.0)
            metabolicRate = getCalorieDeficit(metabolicRate, calorieDeficit);

        return metabolicRate;
    }

    public static Double calculateMifflinstjeor(Person person, Integer age, Double physicalActivityFactor, Double calorieDeficit){

        Double metabolicRate;

        if (person.getSex().equals(Sex.MALE)) {
            metabolicRate = (10 * person.getWeight()) + (6.25 * person.getHeight()) - (5.0 * age) + 5;
        } else {
            metabolicRate = (10 * person.getWeight()) + (6.25 * person.getHeight()) - (5.0 * age) - 161;
        }

        if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
            metabolicRate = getPhysicalActivityFactor(metabolicRate, physicalActivityFactor);

        if (calorieDeficit != null && calorieDeficit > 0.0)
            metabolicRate = getCalorieDeficit(metabolicRate, calorieDeficit);

        return metabolicRate;
    }

    public static Double calculateCunnighAndTinsley(Double freeFatWeight, Double physicalActivityFactor, Double calorieDeficit){

        Double metabolicRate;

        metabolicRate = (22 * freeFatWeight) + 500;

        if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
            metabolicRate = getPhysicalActivityFactor(metabolicRate, physicalActivityFactor);

        if (calorieDeficit != null && calorieDeficit > 0.0)
            metabolicRate = getCalorieDeficit(metabolicRate, calorieDeficit);

        return metabolicRate;
    }

    public static Double calculateHarrisAndBenedict(Person person, Integer age, Double physicalActivityFactor, Double calorieDeficit){

       Double metabolicRate;

        if (person.getSex().equals(Sex.MALE)) {
            metabolicRate = 66 + (13.8 * person.getWeight()) + (5.0 * person.getHeight()) - (6.8 * age);
        } else {
            metabolicRate = 655 + (9.6 * person.getWeight()) + (1.9 * person.getHeight()) - (4.7 * age);
        }

        if (physicalActivityFactor != null && physicalActivityFactor > 0.0)
            metabolicRate = getPhysicalActivityFactor(metabolicRate, physicalActivityFactor);

        if (calorieDeficit != null && calorieDeficit > 0.0)
            metabolicRate = getCalorieDeficit(metabolicRate, calorieDeficit);

        return metabolicRate;
    }

    public static Double getFaoOmsMale(Person person, Integer age, Double physicalActivityFactor, Double calorieDeficit){
        Double metabolicRate;

        if (age >= 10 && age <= 18) {
            metabolicRate = (17.686 * person.getWeight()) + 658.2;
        } else if (age >= 18 && age <= 30) {
            metabolicRate = (15.057 * person.getWeight()) + 692.2;
        } else if (age >= 30 && age <= 60) {
            metabolicRate = (11.472 * person.getWeight()) + 873.1;
        } else {
            metabolicRate = (11.711 * person.getWeight()) + 587.7;
        }

        return metabolicRate;
    }

    public static Double getFaoOmsFemale(Person person, Integer age, Double physicalActivityFactor, Double calorieDeficit){
        Double metabolicRate;

        if (age >= 10 && age <= 18) {
            metabolicRate = (13.384 * person.getWeight()) + 692.6;
        } else if (age >= 18 && age <= 30) {
            metabolicRate = (14.818 * person.getWeight()) + 486.6;
        } else if (age >= 30 && age <= 60) {
            metabolicRate = (8.126 * person.getWeight()) + 845.6;
        } else {
            metabolicRate = (9.082 * person.getWeight()) + 658.5;
        }

        return metabolicRate;
    }

    public static Double getPhysicalActivityFactor(Double metabolicRate, Double physicalActivityFactor){
        return metabolicRate * physicalActivityFactor;
    }

    public static Double getCalorieDeficit(Double metabolicRate, Double calorieDeficit){
        return metabolicRate-calorieDeficit;
    }

}
