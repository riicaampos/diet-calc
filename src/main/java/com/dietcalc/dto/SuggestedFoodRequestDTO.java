package com.dietcalc.dto;

import com.dietcalc.enums.FoodCategories;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuggestedFoodRequestDTO {

    private Long tacoTableId;

    private String description;

    private Double moisture;

    private Double energyKcal;

    private Double energyKj;

    private Double protein;

    private Double lipids;

    private Double cholesterol;

    private Double carbohydrate;

    private Double dietaryFiber;

    private Double ashes;

    private Double calcium;

    private Double magnesium;

    @Enumerated(EnumType.STRING)
    private FoodCategories categorie;

    private Double quantity;

}
