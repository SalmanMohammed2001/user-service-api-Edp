package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.commen.BillingAddressDto;
import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repo.BillingRepo;
import com.eadp.userserviceapi.repo.UserRepo;
import com.eadp.userserviceapi.service.BillingAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BillingAddressServiceImpl implements BillingAddressService {

    private final BillingRepo billingRepo;

    private final UserRepo userRepo;

    public BillingAddressServiceImpl(BillingRepo billingRepo, UserRepo userRepo) {
        this.billingRepo = billingRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void saveBellingAddress(BillingAddressDto dto, String userId) {
        BillingAddress billingAddress = new BillingAddress();

        Optional<User> selectedUserId = userRepo.findUserByUserId(userId);
        if (selectedUserId.isEmpty()) throw new RuntimeException();
        billingAddress.setCountry(dto.getCountry());
        billingAddress.setCity(dto.getCity());
        billingAddress.setZip(dto.getZip());
        billingAddress.setUser(selectedUserId.get());
        billingRepo.save(billingAddress);
    }

    @Override
    public void updateBellingAddress(BillingAddressDto dto, String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();


        Optional<BillingAddress> selectedBillingAddress = billingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();
        selectedBillingAddress.get().setCountry(dto.getCountry());
        selectedBillingAddress.get().setCity(dto.getCity());
        selectedBillingAddress.get().setZip(dto.getZip());
        billingRepo.save(selectedBillingAddress.get());
    }

    @Override
    public BillingAddressDto findBellingAddress(String userId) {

        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        return new BillingAddressDto(
                selectedBillingAddress.get().getCountry(),
                selectedBillingAddress.get().getCity(),
                selectedBillingAddress.get().getZip()
        );
    }

    @Override
    public void deleteBellingAddress(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        billingRepo.deleteById(selectedBillingAddress.get().getPropertyId());
    }
}
