package com.example.appointment.repository;

import com.example.appointment.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetails,Long> {
}
