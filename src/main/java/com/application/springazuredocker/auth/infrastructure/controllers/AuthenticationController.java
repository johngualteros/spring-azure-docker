package com.application.springazuredocker.auth.infrastructure.controllers;

import com.application.springazuredocker.auth.application.services.JwtService;
import com.application.springazuredocker.auth.application.services.UserInfoService;
import com.application.springazuredocker.auth.domain.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private UserInfoService service;
    private JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(
        UserInfoService service,
        JwtService jwtService,
        AuthenticationManager authenticationManager
    ) {
        this.service = service;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
