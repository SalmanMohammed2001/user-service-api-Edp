package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.commen.BillingAddressDto;
import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repo.BellingRepo;
import com.eadp.userserviceapi.repo.UserRepo;
import com.eadp.userserviceapi.service.BillingAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BillingAddressServiceImpl implements BillingAddressService {

    private final BellingRepo bellingRepo;

    private final UserRepo userRepo;

    public BillingAddressServiceImpl(BellingRepo bellingRepo, UserRepo userRepo) {
        this.bellingRepo = bellingRepo;
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
        bellingRepo.save(billingAddress);
    }

    @Override
    public void updateBellingAddress(BillingAddressDto dto, String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();


        Optional<BillingAddress> selectedBillingAddress = bellingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();
        selectedBillingAddress.get().setCountry(dto.getCountry());
        selectedBillingAddress.get().setCity(dto.getCity());
        selectedBillingAddress.get().setZip(dto.getZip());
        bellingRepo.save(selectedBillingAddress.get());
    }

    @Override
    public BillingAddressDto findBellingAddress(String userId) {

        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = bellingRepo.findBillingAddressByUser(selectedUser.get());
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

        Optional<BillingAddress> selectedBillingAddress = bellingRepo.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        bellingRepo.deleteById(selectedBillingAddress.get().getPropertyId());
    }
}
