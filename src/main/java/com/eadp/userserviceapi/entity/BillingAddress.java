package com.eadp.userserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long propertyId;
    private String country;
    private String city;
    private String zip;

    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    private User user;



}
