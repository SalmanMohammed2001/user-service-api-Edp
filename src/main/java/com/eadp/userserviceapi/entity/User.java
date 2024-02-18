package com.eadp.userserviceapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class User {

@Id
    private long propertyId;
    private String userId;
    private String fullName;
    private String email;
    private String avatarUrl;
    private Boolean status;
}
