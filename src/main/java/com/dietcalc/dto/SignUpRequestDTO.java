package com.dietcalc.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"email","password"})
public class SignUpRequestDTO {
    private String email;
    private String password;
}
