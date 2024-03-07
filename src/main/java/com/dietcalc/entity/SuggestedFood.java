package com.dietcalc.entity;

import com.dietcalc.enums.FoodCategories;
import com.dietcalc.enums.SuggestedFoodStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SuggestedFood {

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

    @Enumerated(EnumType.STRING)
    private SuggestedFoodStatus status;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "suggested_by_person_id")
    private Person person;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
