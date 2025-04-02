package com.example.appointment.security;

import com.example.appointment.model.User;
import com.example.appointment.model.UserRole;
import com.example.appointment.repository.UserRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*
This class is for handling JWT operations like generating, validating and extracting information
from tokens. Use a library like io.jsonwebtoken to handle token creation and parsing.
configure secret key and expiration time
*/
@Component
public class JwtUtil {
    // secret key
    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private final int jwtExpirationMs = 86400000;
    private UserRepository userRepository;

    public JwtUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Generate token
    public String generateToken(String username) {
        Optional<User> user = userRepository.findByusername(username);
        Set<UserRole> roles = user.get().getRole();
        //Add roles to token
        return Jwts.builder().setSubject(username).claim("roles", roles.stream()
                        .map(role -> role.getName()).collect(Collectors.joining(",")))
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(secretKey).compact();

    }

    //Extract username
    public String extractUserName(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody()
                .getSubject();
    }

    // Extract Roles
    public Set<String> extractRoles(String token) {
        String rolesString = Jwts.parserBuilder().setSigningKey(secretKey)
                .build().parseClaimsJws(token).getBody().get("roles", String.class);
        return Set.of(rolesString);
    }

    //Token Validation
    public boolean isTokenValid(String token){
        try{
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        }catch(JwtException | IllegalArgumentException e){
            return false;
        }

    }
}

