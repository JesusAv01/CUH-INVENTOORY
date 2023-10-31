package mx.com.cuh.service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import mx.com.cuh.entity.Role;
import mx.com.cuh.entity.User;
import mx.com.cuh.repository.UserRepository;
import mx.com.cuh.request.AuthResponse;
import mx.com.cuh.request.LoginRequest;
import mx.com.cuh.request.SignupRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(SignupRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new NoSuchElementException("El usuario no se encuentra en la base de datos"));
        var jwtToken = jwtService.generateToken(user); 
        return AuthResponse.builder().token(jwtToken).build();
    }


}
