package com.dietcalc.utils;

import com.dietcalc.enums.Equations;

public class AboutEquations {

    public static String aboutEquations(Equations equations){

        switch (equations){

            case FAOOMS:
               return Utils.getMessage("about.faooms");

            case MIFFLINSTJEOR:
               return Utils.getMessage("about.mifflinstjeor");

            case CUNNIGHAMDTINSLEY:
             return Utils.getMessage("about.cunnighamdtinsley");

            case HARRISANDBENEDICT:
              return Utils.getMessage("about.harrisandbenedict");

            default:
                return "Equação não encontrada";
        }

    }

    public static String physicalActivityFactors(){
        return new StringBuilder()
                        .append(Utils.getMessage("physical.activity.factors.14")+"\n")
                        .append(Utils.getMessage("physical.activity.factors.15")+"\n")
                        .append(Utils.getMessage("physical.activity.factors.16")+"\n")
                        .append(Utils.getMessage("physical.activity.factors.17")+"\n")
                        .append(Utils.getMessage("physical.activity.factors.1819")+"\n")
                        .append(Utils.getMessage("physical.activity.factors.2more")+"\n").toString();

    }

    public static String deficitSuggestions(){
        return new StringBuilder()
                .append(Utils.getMessage("deficit.suggestion1")+"\n")
                .append(Utils.getMessage("deficit.suggestion2")+"\n")
                .append(Utils.getMessage("deficit.suggestion3")+"\n").toString();

    }


}
