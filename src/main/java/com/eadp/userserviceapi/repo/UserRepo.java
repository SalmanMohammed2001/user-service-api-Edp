package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    public Optional<User> findUserByUserId(String id);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE full_name LIKE %?1% OR email LIKE %?1%")
    public List<User> findAllUser(String searchText, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM user WHERE full_name LIKE %?1% OR email LIKE %?1%")
    public long findAllUserCount(String searchText);
}
