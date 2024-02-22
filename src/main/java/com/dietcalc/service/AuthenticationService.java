package com.dietcalc.service;

import com.dietcalc.dto.JwtAuthenticationResponseDTO;
import com.dietcalc.dto.SignUpRequestDTO;
import com.dietcalc.dto.SigninRequestDTO;

public interface AuthenticationService {
    JwtAuthenticationResponseDTO signup(SignUpRequestDTO request);

    JwtAuthenticationResponseDTO signin(SigninRequestDTO request);



}
