package com.eadp.userserviceapi.repo;

import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.ShippingAddress;
import com.eadp.userserviceapi.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShippingRepo extends JpaRepository<ShippingAddress,Long> {

    public Optional<ShippingAddress> findBillingAddressByUser(User user);
}
