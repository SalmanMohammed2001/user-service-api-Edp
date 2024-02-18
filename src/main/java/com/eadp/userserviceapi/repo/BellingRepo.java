package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.ShippingAddress;
import com.eadp.userserviceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BellingRepo extends JpaRepository<BillingAddress,Long> {

    public Optional<BillingAddress> findBillingAddressByUser(User user);

}
