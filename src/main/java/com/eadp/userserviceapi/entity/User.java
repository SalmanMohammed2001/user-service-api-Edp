package com.eadp.userserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property-id")
    private long propertyId;

    @Column(name = "user-id", unique = true)
    private String userId;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    @Lob
    private byte[] avatarUrl;

    private Boolean status;
}
