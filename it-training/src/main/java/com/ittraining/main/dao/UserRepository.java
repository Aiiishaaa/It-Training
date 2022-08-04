package com.ittraining.main.dao;


import java.util.List;

import com.ittraining.main.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    
    public List<User> findAllBySessionsId(Integer idSession);

}