package com.dietcalc.service;

import com.dietcalc.dto.NutricionalTableResponseDTO;
import com.dietcalc.entity.NutritionalTable;

import java.io.IOException;
import java.util.List;

public interface NutritionalTableService {

    void saveFood(NutritionalTable food);

    void populateTable();

    List<NutricionalTableResponseDTO> listNutricionalTable();

    List<NutricionalTableResponseDTO> findFoodByDescription(String description);

}
