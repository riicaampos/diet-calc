package com.dietcalc.service;

import com.dietcalc.dto.DietRequestDTO;

public interface DietService {

    void calculateDiet(DietRequestDTO dietRequest);
}
