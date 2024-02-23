package com.dietcalc.utils;

import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

public class Utils {

    public static Integer calculateAgeBetweenDates(Date personBirthDate){
        LocalDate nowDate = LocalDate.now();

        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal.setTime(personBirthDate);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        LocalDate birthDate = LocalDate.of(year, month, day);

        return (Period.between(nowDate, birthDate).getYears())*-1;
    }

    public static String getMessage(String key) {
        return ResourceBundle.getBundle("messages", LocaleContextHolder.getLocale()).getString(key);
    }

    public static Double calculateFatFreeWeight(Double fatPercent, Double personWeight){
        fatPercent = fatPercent/100;
        Double fatWeight = personWeight * fatPercent;

        return personWeight-fatWeight;
    }

}
