package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.commen.BillingAddressDto;
import com.eadp.userserviceapi.service.BillingAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BillingAddressServiceImpl implements BillingAddressService {
    @Override
    public void saveBellingAddress(BillingAddressDto dto, String userId) {

    }

    @Override
    public void updateBellingAddress(BillingAddressDto dto, String userId) {

    }

    @Override
    public BillingAddressDto findBellingAddress(String userId) {
        return null;
    }

    @Override
    public void deleteBellingAddress(String userId) {

    }
}
