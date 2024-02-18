package com.eadp.userserviceapi.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddress {
    private String country;
    private String city;
    private String zip;
}
