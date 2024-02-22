package com.dietcalc.service.impl;

import com.dietcalc.dto.JwtAuthenticationResponseDTO;
import com.dietcalc.dto.SignUpRequestDTO;
import com.dietcalc.dto.SigninRequestDTO;
import com.dietcalc.entity.User;
import com.dietcalc.enums.Role;
import com.dietcalc.repository.UserRepository;
import com.dietcalc.service.AuthenticationService;
import com.dietcalc.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponseDTO signup(SignUpRequestDTO request) {
        var user = User.builder().email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponseDTO.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponseDTO signin(SigninRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponseDTO.builder().token(jwt).build();
    }

}
