package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.commen.ShippingAddressDto;
import com.eadp.userserviceapi.service.ShippingAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShippingAddressServiceImpl implements ShippingAddressService {
    @Override
    public void saveShippingAddress(ShippingAddressDto dto, String userId) {

    }

    @Override
    public void updateShippingAddress(ShippingAddressDto dto, String userId) {

    }

    @Override
    public ShippingAddressDto findShippingAddress(String userId) {
        return null;
    }

    @Override
    public void deleteShippingAddress(String userId) {

    }
}
