package com.dietcalc.dto;

import com.dietcalc.entity.Diet;
import com.dietcalc.entity.Person;
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

    private Double metabolicRate;

    public DietResponseDTO(){
        this.protein = new ProteinResponseDTO();
        this.carbohydrate = new CarbResponseDTO();
        this.fat = new FatResponseDTO();
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
        private Double qntProteinGr;
        private Double qntProteinGrKgBody;
        private Double percProtein;
        private Double calProtein;
    }

    @Data
    public class CarbResponseDTO{
        private Double qntCarbGr;
        private Double qntCarbGrKgBody;
        private Double percCarb;
        private Double calCarb;
    }

    @Data
    public class FatResponseDTO{
        private Double qntFatGr;
        private Double qntFatGrKgBody;
        private Double percFat;
        private Double calFat;
    }

}


