package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
