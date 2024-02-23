package com.dietcalc.service;

import com.dietcalc.enums.Equations;

public interface CalculateMetabolicRateService {

    Double calculateMetabolicRate(Equations equations, Double fatPercent, Double physicalActivityFactor, Double calorieDeficit);

}
