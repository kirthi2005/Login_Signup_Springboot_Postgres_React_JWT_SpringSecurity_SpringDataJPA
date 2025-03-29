package com.example.appointment.repository;

import com.example.appointment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //Optional<User> findByUsername(String username);
    //Optional<User>findByName(String username);
    Optional<User> findByusername(String username);
}
