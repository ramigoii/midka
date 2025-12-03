package com.example.midka.repository;

import com.example.midka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User,Long> {
    User findByEmail(String username);
}
