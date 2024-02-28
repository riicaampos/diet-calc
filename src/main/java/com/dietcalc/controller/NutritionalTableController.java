package com.dietcalc.controller;

import com.dietcalc.dto.NutricionalTableResponseDTO;
import com.dietcalc.service.NutritionalTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nutricional-table")
@RequiredArgsConstructor
public class NutritionalTableController {

    private final NutritionalTableService nutritionalTableService;

    @GetMapping("/populate-table")
    public void populateTable(){
        this.nutritionalTableService.populateTable();
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<NutricionalTableResponseDTO>> getNutricionalTable(){
        return ResponseEntity.ok().body(this.nutritionalTableService.listNutricionalTable());
    }

    @GetMapping("/by-description")
    public ResponseEntity<List<NutricionalTableResponseDTO>> getByDescription(@RequestParam("description") String description){
        return ResponseEntity.ok().body(this.nutritionalTableService.findFoodByDescription(description));
    }

}
