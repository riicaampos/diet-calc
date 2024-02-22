package com.dietcalc.enums;

public enum Equations {
    HARRISANDBENEDICT("Harris e Benedict"),
    FAOOMS("FAO/OMS"),
    MIFFLINSTJEOR("Mifflin-St Jeor"),
    CUNNIGHAMDTINSLEY("Cunningham e Tinsley");

    private String description;

    private Equations(String description){
        this.description = description;
    }

}
