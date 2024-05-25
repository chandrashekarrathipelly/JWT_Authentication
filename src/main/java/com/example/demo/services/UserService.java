package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.DTO.UserDto;
import com.example.demo.entites.User;
import com.example.demo.repositories.UserRepo;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public String login(UserDto userDto) {
        // Generate JWT token
        return "";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Invalid User"));
        return user;
    }

    public void createUser(User user) {
        this.userRepo.save(user);

    }

}
