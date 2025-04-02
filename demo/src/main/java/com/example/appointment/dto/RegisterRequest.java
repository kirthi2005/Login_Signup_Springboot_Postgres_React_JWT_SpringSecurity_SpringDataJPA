package com.example.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RegisterRequest {
    private String username;
    private String password;
    //private Set<String> Roles = new HashSet<>(Arrays.asList("USER", "ADMIN")); // A set of role names to be passed in the request
    private Set<String> Roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return Roles;
    }

    public void setRoles(Set<String> roles) {
        this.Roles = roles;
    }
    /*public void setRoles(String role) {
        Roles.add(role);
    }*/
}
