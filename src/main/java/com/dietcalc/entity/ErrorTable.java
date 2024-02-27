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
public class ErrorTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lineError;

    private String errorMessage;

    @Enumerated(EnumType.STRING)
    private FoodCategories categorie;
}
