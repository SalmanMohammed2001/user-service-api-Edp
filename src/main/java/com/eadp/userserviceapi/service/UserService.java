package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.paginate.PaginateUserResponseUserDto;
import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;

import java.util.List;

public interface UserService {

    public void createUser(RequestUserDto dto);
    public void updateUser(RequestUserDto dto, String userID);
    public ResponseUserDto fidUser(String userId);
    public void deleteUser(String userId);
    public List<PaginateUserResponseUserDto> findAllUser(int page, int size, String searchText);
}
