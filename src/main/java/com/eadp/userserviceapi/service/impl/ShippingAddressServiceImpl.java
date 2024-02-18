package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.commen.BillingAddressDto;
import com.eadp.userserviceapi.dto.commen.ShippingAddressDto;
import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.ShippingAddress;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repo.ShippingRepo;
import com.eadp.userserviceapi.repo.UserRepo;
import com.eadp.userserviceapi.service.ShippingAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ShippingAddressServiceImpl implements ShippingAddressService {

    private final ShippingRepo shippingRepo;

    private final UserRepo userRepo;
    public ShippingAddressServiceImpl(ShippingRepo shippingRepo, UserRepo userRepo) {
        this.shippingRepo = shippingRepo;

        this.userRepo = userRepo;
    }

    @Override
    public void saveShippingAddress(ShippingAddressDto dto, String userId) {
        ShippingAddress shippingAddress = new ShippingAddress();

        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        shippingAddress.setCountry(dto.getCountry());
        shippingAddress.setCity(dto.getCity());
        shippingAddress.setZip(dto.getZip());
        shippingAddress.setUser(selectedUser.get());
        shippingRepo.save(shippingAddress);
    }

    @Override
    public void updateShippingAddress(ShippingAddressDto dto, String userId) {

        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();


        Optional<ShippingAddress> selectedShippingAddress = shippingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();
        selectedShippingAddress.get().setCountry(dto.getCountry());
        selectedShippingAddress.get().setCity(dto.getCity());
        selectedShippingAddress.get().setZip(dto.getZip());
        shippingRepo.save(selectedShippingAddress.get());

    }

    @Override
    public ShippingAddressDto findShippingAddress(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();

        return new ShippingAddressDto(
                selectedShippingAddress.get().getCountry(),
                selectedShippingAddress.get().getCity(),
                selectedShippingAddress.get().getZip()
        );
    }

    @Override
    public void deleteShippingAddress(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();
        shippingRepo.deleteById(selectedShippingAddress.get().getPropertyId());
    }
}
