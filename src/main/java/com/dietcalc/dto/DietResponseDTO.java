package com.dietcalc.dto;

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


