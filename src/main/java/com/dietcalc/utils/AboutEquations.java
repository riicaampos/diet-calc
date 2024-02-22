package com.dietcalc.utils;

import com.dietcalc.enums.Equations;

public class AboutEquations {

    public static String getAboutEquations(Equations equations){

        switch (equations){

            case FAOOMS:
               return "Pode ser utilizado também para o cálculo de gastos energéticos de bebês. \n"
                     +"Mede a taxa metabólica basal do paciente e deve ser posteriormente multiplicada pelo fator atividade para que tenhamos o gasto energético total";

            case MIFFLINSTJEOR:
               return "É a mais indicada para o cálculo de indivíduos obesos.";

            case CUNNIGHAMDTINSLEY:
             return "Necessita saber a sua massa livre de gordura. "
                  + "Mais indicada para o cálculo de indivíduos com grande volume muscular e baixo percentual de gordura.";

            case HARRISANDBENEDICT:
              return "Essa pode não ser a opção mais indicada para algumas pessoas, uma vez que esta equação não considera a massa corporal livre de gordura nem a relação entre massa muscular e massa gorda.";

            default:
                return "Equação não encontrada";

        }

    }

    public static String physicalActivityFactors(){
        return new StringBuilder()
                .append("Muito sedentário: 1,4 \n")
                .append("Sedentário pouco ativo: 1,5 \n")
                .append("Sedentário mais ativo: 1,6 \n")
                .append("Moderadamente ativo (treina): 1,7 \n")
                .append("Muito ativo: 1,8 a 1,9")
                .append("Atividade intensa: 2,0 ou mais").toString();

    }

}
