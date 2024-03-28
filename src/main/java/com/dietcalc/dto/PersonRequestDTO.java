package com.dietcalc.dto;

import com.dietcalc.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private Long id;

    private String firstName;
    private String lastName;

    private Date birthDate;

    private Double weight;
    private Double height;

    private Double fatPercent;

    private Sex sex;

    private Long userId;

}
