package com.dietcalc.entity;

import com.dietcalc.enums.FoodCategories;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NutritionalTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
