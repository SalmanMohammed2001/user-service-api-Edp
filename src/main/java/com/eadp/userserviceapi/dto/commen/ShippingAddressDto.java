package com.eadp.userserviceapi.dto.commen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddressDto {
    private String country;
    private String city;
    private String zip;
}
