package com.eadp.userserviceapi.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {

    private long propertyId;
    private String userId;
    private String fullName;
    private String email;
    private String avatarUrl;
    private Boolean status;
}
