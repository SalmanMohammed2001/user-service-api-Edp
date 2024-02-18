package com.eadp.userserviceapi.dto.requst;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RequestUserDto {

    private String fullName;
    private String email;
    private String avatarUrl;
    private String password;
    private Boolean status;
}
