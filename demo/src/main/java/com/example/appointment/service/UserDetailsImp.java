/*package com.example.appointment.service;


import com.example.appointment.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
*/
//for authentication purpose spring security uses another special object named
//UserDetailsService
//@Service
/*public class UserDetailsImp implements UserDetailsService {
    private final UserRepository userRepository;

    // constructor for dependency injection
    public UserDetailsImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   // @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
*/