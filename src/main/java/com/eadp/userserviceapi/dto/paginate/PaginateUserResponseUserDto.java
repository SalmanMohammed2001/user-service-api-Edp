package com.eadp.userserviceapi.dto.paginate;

import com.eadp.userserviceapi.dto.response.ResponseUserDto;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaginateUserResponseUserDto {

    private long count;

    private List<ResponseUserDto> data;



}
