package mx.com.cuh.controller;

import lombok.RequiredArgsConstructor;
import mx.com.cuh.request.AuthResponse;
import mx.com.cuh.request.LoginRequest;
import mx.com.cuh.request.SignupRequest;
import mx.com.cuh.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Auth_Controller {

    @Autowired
    private AuthService authService;

    @PostMapping( "/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping( "/signin")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

}
