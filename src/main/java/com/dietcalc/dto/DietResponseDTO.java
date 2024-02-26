package com.dietcalc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietResponseDTO {

    private Double qntProteinGr;
    private Double percProtein;
    private Double calProtein;

    private Double qntCarbGr;
    private Double percCarb;
    private Double calCarb;

    private Double qntFatGr;
    private Double percFat;
    private Double calFat;

}
