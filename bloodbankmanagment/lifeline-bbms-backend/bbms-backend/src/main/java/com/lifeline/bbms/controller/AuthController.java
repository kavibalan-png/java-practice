package com.lifeline.bbms.controller;

import com.lifeline.bbms.config.JwtUtil;
import com.lifeline.bbms.dto.AuthResponse;
import com.lifeline.bbms.dto.LoginRequest;
import com.lifeline.bbms.entity.Admin;
import com.lifeline.bbms.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        Admin admin = adminRepository.findByUsername(req.getUsername()).orElse(null);
        if (admin == null || !passwordEncoder.matches(req.getPassword(), admin.getPassword())) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        String token = jwtUtil.generateToken(admin.getUsername());
        return ResponseEntity.ok(new AuthResponse(token, admin.getUsername(), admin.getFullName()));
    }
}
