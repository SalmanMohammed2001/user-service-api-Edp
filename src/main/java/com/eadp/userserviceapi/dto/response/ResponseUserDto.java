package com.eadp.userserviceapi.dto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ResponseUserDto {

    private String fullName;
    private String email;
    private String avatarUrl;
    private Boolean status;
}
