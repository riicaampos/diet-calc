package com.dietcalc.dto;

import com.dietcalc.entity.Diet;
import com.dietcalc.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class DietResponseDTO {

   private ProteinResponseDTO protein;
   private CarbResponseDTO carbohydrate;
   private FatResponseDTO fat;

    private ProteinResponseDTO proteinPerMeal;
    private CarbResponseDTO carbohydratePerMeal;
    private FatResponseDTO fatPerMeal;

    private Double metabolicRate;

    private Long numberOfMeals;

    public DietResponseDTO(){
        this.protein = new ProteinResponseDTO();
        this.carbohydrate = new CarbResponseDTO();
        this.fat = new FatResponseDTO();
        this.proteinPerMeal = new ProteinResponseDTO();
        this.carbohydratePerMeal = new CarbResponseDTO();
        this.fatPerMeal = new FatResponseDTO();
    }

    public DietResponseDTO(Diet diet, Person person){
        this.protein = new ProteinResponseDTO();
        this.carbohydrate = new CarbResponseDTO();
        this.fat = new FatResponseDTO();

        this.protein.setCalProtein(diet.getCalProtein());
        this.protein.setPercProtein(diet.getPercProtein());
        this.protein.setQntProteinGr(diet.getQntProteinGr());
        this.protein.setQntProteinGrKgBody(diet.getQntProteinGrKgBody());

        this.carbohydrate.setPercCarb(diet.getPercCarb());
        this.carbohydrate.setCalCarb(diet.getCalCarb());
        this.carbohydrate.setQntCarbGr(diet.getQntCarbGr());
        this.carbohydrate.setQntCarbGrKgBody(diet.getQntCarbGrKgBody());

        this.fat.setCalFat(diet.getCalFat());
        this.fat.setPercFat(diet.getPercFat());
        this.fat.setQntFatGr(diet.getQntFatGr());
        this.fat.setQntFatGrKgBody(diet.getQntFatGrKgBody());

        this.metabolicRate = person.getMetabolicRate();
    }

    @Data
    public class ProteinResponseDTO{
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double qntProteinGr;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double qntProteinGrKgBody;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double percProtein;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double calProtein;
    }

    @Data
    public class CarbResponseDTO{

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double qntCarbGr;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double qntCarbGrKgBody;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double percCarb;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double calCarb;
    }

    @Data
    public class FatResponseDTO{

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double qntFatGr;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double qntFatGrKgBody;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double percFat;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private Double calFat;
    }

}


