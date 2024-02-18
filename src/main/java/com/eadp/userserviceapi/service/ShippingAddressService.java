package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.commen.ShippingAddressDto;
import com.eadp.userserviceapi.dto.paginate.PaginateUserResponseUserDto;
import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;

public interface ShippingAddressService {

    public void saveShippingAddress(ShippingAddressDto dto,String userId);
    public void updateShippingAddress(ShippingAddressDto dto,String userId);

    public ShippingAddressDto findShippingAddress(String userId);
    public void deleteShippingAddress(String userId);



}
