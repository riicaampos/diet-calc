package com.dietcalc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietRequestDTO {

    private Double percProtein;
    private Double grPerKgProt;

    private Double percCarb;
    private Double percFat;

    private Long numberOfMeals;




}
