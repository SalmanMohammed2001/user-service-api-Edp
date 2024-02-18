package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    public Optional<User> findUserByUserId(String id);
}
