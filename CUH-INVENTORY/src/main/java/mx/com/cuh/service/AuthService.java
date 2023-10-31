package mx.com.cuh.service;

import mx.com.cuh.request.AuthResponse;
import mx.com.cuh.request.LoginRequest;
import mx.com.cuh.request.SignupRequest;

public interface AuthService {
    AuthResponse register(SignupRequest request);

    AuthResponse login(LoginRequest request);


}
