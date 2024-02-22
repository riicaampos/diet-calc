package com.dietcalc.controller;

import com.dietcalc.dto.JwtAuthenticationResponseDTO;
import com.dietcalc.dto.SignUpRequestDTO;
import com.dietcalc.dto.SigninRequestDTO;
import com.dietcalc.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponseDTO> signup(@RequestBody SignUpRequestDTO request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponseDTO> signin(@RequestBody SigninRequestDTO request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
