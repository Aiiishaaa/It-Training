package com.ittraining.main.security;

import com.ittraining.main.models.User;

import java.util.Optional;

import com.ittraining.main.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No username with " + username);
        } else {
        return UserDetailsImpl.build(user);
        }
    }
}