package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.paginate.PaginateUserResponseUserDto;
import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;
import com.eadp.userserviceapi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public void createUser(RequestUserDto dto) {

    }

    @Override
    public void updateUser(RequestUserDto dto, String userID) {

    }

    @Override
    public ResponseUserDto fidUser(String userId) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<PaginateUserResponseUserDto> findUser(int page, int size, String searchText) {
        return null;
    }
}
