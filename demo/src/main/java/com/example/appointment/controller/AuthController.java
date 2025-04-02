package com.example.appointment.controller;

import com.example.appointment.dto.RegisterRequest;
import com.example.appointment.model.User;
import com.example.appointment.model.UserRole;
import com.example.appointment.repository.RoleRepository;
import com.example.appointment.repository.UserRepository;
import com.example.appointment.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173/")
//@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "Content-Type, Authorization") // Configure for specific origin
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register User API
    @PostMapping("/register")
    /*public String register()
    {
        return"hello world";
    }*/

    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
        System.out.println("Received username registration request: " + registerRequest.getUsername());
        System.out.println("Received password registration request: " + registerRequest.getPassword());
        System.out.println("role in registration request: " + registerRequest.getRoles());
        //check if username already exists
        if(userRepository.findByusername(registerRequest.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        System.out.println("username for newuser: " + newUser.getUsername());

        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        newUser.setPassword(encodedPassword);
        System.out.println("Encoded Password for new user: "+ encodedPassword);

        //convert role names to role entities and assign to user
        Set<UserRole> roles = new HashSet<>();
        //UserRole user = new UserRole();

        /*for (String roleName : registerRequest.getRoles()) {
            UserRole role = roleRepository.findByname(roleName)
                    .orElse(roleRepository.findByname("USER")
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)));
            System.out.println("role: " + role.getName());
            roles.add(role);
        }
        newUser.setRole(roles);*/

        userRepository.save(newUser);
        return ResponseEntity.ok("User Registered Successfully");
    }
    //login API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest){
        System.out.println("login credentials: " + loginRequest.getUsername() + loginRequest.getPassword());
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
        String token = jwtUtil.generateToken(loginRequest.getUsername());
        return ResponseEntity.ok(token);
    }

}
