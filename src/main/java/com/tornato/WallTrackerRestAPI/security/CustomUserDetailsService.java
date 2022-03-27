package com.tornato.WallTrackerRestAPI.security;

import com.tornato.WallTrackerRestAPI.entity.User;
import com.tornato.WallTrackerRestAPI.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(username)
                .orElseThrow(() -> new UsernameNotFoundException("Dieser Benutzer konnte nicht gefunden werden."));

        return new org.springframework.security.core.userdetails.User(
                user.getEmailId(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
