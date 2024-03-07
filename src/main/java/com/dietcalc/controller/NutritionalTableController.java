package com.dietcalc.controller;

import com.dietcalc.dto.NutricionalTableResponseDTO;
import com.dietcalc.dto.SuggestedFoodRequestDTO;
import com.dietcalc.service.NutritionalTableService;
import com.dietcalc.service.SuggestedFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nutricional-table")
@RequiredArgsConstructor
public class NutritionalTableController {

    private final NutritionalTableService nutritionalTableService;
    private final SuggestedFoodService suggestedFoodService;

    @GetMapping("/populate-table")
    public ResponseEntity<Void> populateTable(@RequestParam("fileName") String fileName,
                                              @RequestParam("categories") String categories){
        this.nutritionalTableService.populateTable(fileName, categories);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<NutricionalTableResponseDTO>> getNutricionalTable(){
        return ResponseEntity.ok().body(this.nutritionalTableService.listNutricionalTable());
    }

    @GetMapping("/by-description")
    public ResponseEntity<List<NutricionalTableResponseDTO>> getByDescription(@RequestParam("description") String description){
        return ResponseEntity.ok().body(this.nutritionalTableService.findFoodByDescription(description));
    }

    @PostMapping("/suggest-new-food")
    public ResponseEntity<Void> suggestNewFood(@RequestBody SuggestedFoodRequestDTO request){
        this.suggestedFoodService.saveSuggestion(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/approve-suggestion")
    public ResponseEntity<Void> approveSuggestion(@RequestParam("suggestionId") Long suggestionId){
        this.suggestedFoodService.approveSuggestion(suggestionId);
        return ResponseEntity.ok().build();
    }
}
