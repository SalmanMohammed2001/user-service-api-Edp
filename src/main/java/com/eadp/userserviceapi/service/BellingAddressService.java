package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.commen.BillingAddressDto;
import com.eadp.userserviceapi.dto.commen.ShippingAddressDto;

public interface BellingAddressService {

    public void saveBellingAddress(BillingAddressDto dto, String userId);
    public void updateBellingAddress(BillingAddressDto dto,String userId);

    public BillingAddressDto findBellingAddress(String userId);
    public void deleteBellingAddress(String userId);



}
