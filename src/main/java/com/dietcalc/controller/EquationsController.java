package com.dietcalc.controller;

import com.dietcalc.enums.Equations;
import com.dietcalc.service.CalculateMetabolicRateService;
import com.dietcalc.utils.AboutEquations;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/equations")
@RequiredArgsConstructor
public class EquationsController {

    private final CalculateMetabolicRateService metabolicRateService;

    @GetMapping()
    public ResponseEntity<String> getAboutEquations(@RequestParam("type") String type) {
        return ResponseEntity.ok().body(AboutEquations.aboutEquations(Equations.valueOf(type.toUpperCase())));
    }

    @GetMapping("/deficit-suggestions")
    public ResponseEntity<String> getDeficitSuggestions(){
        return ResponseEntity.ok().body(AboutEquations.deficitSuggestions());
    }

    @GetMapping("/physical-activity-factors")
    public ResponseEntity<String> getPhysicalActivityFactors() {
        return ResponseEntity.ok().body(AboutEquations.physicalActivityFactors());
    }

    @GetMapping("/calculate")
    public ResponseEntity<Double> getMetabolicRate(@RequestParam("type") String type,
                                                   @RequestParam(value = "fatPercent", required = false) Double fatPercent,
                                                   @RequestParam(value = "physicalActivityFactor", required = false) Double physicalActivityFactor,
                                                   @RequestParam(value = "calorieDeficit", required = false) Double calorieDeficit) {
        return ResponseEntity.ok().body(this.metabolicRateService.calculateMetabolicRate(Equations.valueOf(type.toUpperCase()), fatPercent, physicalActivityFactor, calorieDeficit));
    }

}
