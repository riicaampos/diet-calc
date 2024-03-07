package com.dietcalc.entity;

import com.dietcalc.dto.DietResponseDTO;
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
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double qntProteinGr;
    private Double qntProteinGrKgBody;
    private Double percProtein;
    private Double calProtein;

    private Double qntCarbGr;
    private Double qntCarbGrKgBody;
    private Double percCarb;
    private Double calCarb;

    private Double qntFatGr;
    private Double qntFatGrKgBody;
    private Double percFat;
    private Double calFat;

    private Long numberOfMeals;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Diet(DietResponseDTO dto, Person person){
        this.qntProteinGr = dto.getProtein().getQntProteinGr();
        this.qntProteinGrKgBody = dto.getProtein().getQntProteinGrKgBody();
        this.percProtein = dto.getProtein().getPercProtein();
        this.calProtein = dto.getProtein().getCalProtein();

        this.qntCarbGr = dto.getCarbohydrate().getQntCarbGr();
        this.qntCarbGrKgBody = dto.getCarbohydrate().getQntCarbGrKgBody();
        this.percCarb = dto.getCarbohydrate().getPercCarb();
        this.calCarb = dto.getCarbohydrate().getCalCarb();

        this.qntFatGr = dto.getFat().getQntFatGr();
        this.qntFatGrKgBody = dto.getFat().getQntFatGrKgBody();
        this.percFat = dto.getFat().getPercFat();
        this.calFat = dto.getFat().getCalFat();
        this.numberOfMeals = dto.getNumberOfMeals();

        this.person = person;
    }
}
