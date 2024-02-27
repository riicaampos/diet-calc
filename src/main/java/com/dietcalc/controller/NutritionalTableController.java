package com.dietcalc.controller;

import com.dietcalc.service.NutritionalTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nutricional-table")
@RequiredArgsConstructor
public class NutritionalTableController {

    private final NutritionalTableService nutritionalTableService;

    @GetMapping()
    public void populateTable(){
        this.nutritionalTableService.populateTable();
    }

}
