package com.example.appointment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor

//for user authentication and authorization spring security uses a special object that is UserDetails.
//this is a interface and we need to implement this
@Entity  //Entity in JAP is a plain old java object representing data that can be persisted in the database
@Table(name = "users")
//public class User implements UserDetails {
public class User {
    //if we use GenerationType.AUTO spring jpa will choose the best applicable strategy for ID generation
    //for the databse
    //GenerationType.INCREMENT - it will rely on the database Auto increments feature
    //GenerationType.SEQUENCE - it will rely on database sequence to generate unique identifier values
    //for our entities
    //GenerationType.IDENTITY - auto incremented
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;



    /*@Enumerated(value=EnumType.STRING)
    private Role role;*/

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<UserRole> role = new HashSet<>(); // many users can have multiple roles

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<UserRole> getRole() {
        return role;
    }

    public void setRole(Set<UserRole> role) {
        this.role = role;
    }


/*public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }*/

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }*/

    /*@Override
    public boolean isAccountNonExpired() {
        //return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return UserDetails.super.isEnabled();
        return true;
    }*/

    /*public void setUsername(String username) {
        this.username = username;
    }*/

    //this method should return the list of role that our user have
    //@Override
    /*public Collection<? extends GrantedAuthority> getAuthorities() {
        //return null;
        return List.of(new SimpleGrantedAuthority(role.name()));
    }*/

    /*public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
}
