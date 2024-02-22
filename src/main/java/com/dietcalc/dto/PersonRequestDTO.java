package com.dietcalc.dto;

import com.dietcalc.enums.Sex;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDTO implements Serializable {

    private String firstName;
    private String lastName;

    private Date birthDate;

    private Double weight;
    private Double height;

    private Sex sex;

}
