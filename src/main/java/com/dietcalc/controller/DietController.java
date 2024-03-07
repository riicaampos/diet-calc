package com.dietcalc.controller;

import com.dietcalc.dto.DietRequestDTO;
import com.dietcalc.dto.DietResponseDTO;
import com.dietcalc.service.DietService;
import com.dietcalc.utils.AboutEquations;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @GetMapping("/macro-calories")
    public ResponseEntity<String> getMacroCalories(){
        return ResponseEntity.ok().body(AboutEquations.aboutMacroNutrientsCalorie());
    }

    @GetMapping("/calculate")
    public ResponseEntity<DietResponseDTO> calculateDiet(@RequestBody DietRequestDTO dietRequestDTO){
        return ResponseEntity.ok().body(this.dietService.calculateDiet(dietRequestDTO));
    }

    @GetMapping()
    public ResponseEntity<DietResponseDTO> getMyDiet(){
       return ResponseEntity.ok().body(dietService.findByPersonByDto());
    }

}
