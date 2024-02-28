package com.dietcalc.dto;

import com.dietcalc.enums.FoodCategories;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NutricionalTableResponseDTO {

    private Long tacoTableId;

    private String description;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double moisture;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double energyKcal;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double energyKj;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double protein;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double lipids;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double cholesterol;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double carbohydrate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double dietaryFiber;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double ashes;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double calcium;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Double magnesium;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private FoodCategories categorie;

    private Double quantity;
}
