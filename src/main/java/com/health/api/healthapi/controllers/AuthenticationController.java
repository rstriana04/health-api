package com.health.api.healthapi.controllers;

import com.health.api.healthapi.models.User;
import com.health.api.healthapi.payload.request.LoginRequest;
import com.health.api.healthapi.payload.request.SignUpRequest;
import com.health.api.healthapi.payload.response.JwtResponse;
import com.health.api.healthapi.repository.IUserRepository;
import com.health.api.healthapi.security.jwt.JwtUtils;
import com.health.api.healthapi.security.services.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/log-in")
    public ResponseEntity<Object> logIn(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

        try {
            iUserRepository.updateToken(userDetails.getId(), jwt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userDetails.getId() != null) {
            return new ResponseEntity<Object>(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail()), HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (iUserRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Error: Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (iUserRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Error: Email is already in use!", HttpStatus.BAD_REQUEST);
        }
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                signUpRequest.getName(),
                signUpRequest.getLastName(),
                signUpRequest.getDateBirth(),
                signUpRequest.getPhone(),
                signUpRequest.getGender(),
                signUpRequest.getDni(),
                encoder.encode(signUpRequest.getPassword())
        );

        iUserRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);
        }
        return "Sesión Cerrada correctamente";
    }

    @GetMapping("/{token}")
    public ResponseEntity<Optional<User>> getUserAuthenticated(@PathVariable String token) {
        Optional<User> user = iUserRepository.findByAccessToken(token);
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
