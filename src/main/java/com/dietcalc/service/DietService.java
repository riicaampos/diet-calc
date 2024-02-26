package com.dietcalc.service;

import com.dietcalc.dto.DietRequestDTO;
import com.dietcalc.dto.DietResponseDTO;

public interface DietService {

    DietResponseDTO calculateDiet(DietRequestDTO dietRequest);
}
