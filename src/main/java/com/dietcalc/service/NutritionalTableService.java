package com.dietcalc.service;

import com.dietcalc.entity.NutritionalTable;

import java.io.IOException;

public interface NutritionalTableService {

    void saveFood(NutritionalTable food);

    void populateTable();

}
