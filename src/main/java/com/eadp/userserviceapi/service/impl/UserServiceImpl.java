package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.paginate.PaginateUserResponseUserDto;
import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repo.UserRepo;
import com.eadp.userserviceapi.service.UserService;
import com.eadp.userserviceapi.util.KeyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final KeyManager keyManager;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, KeyManager keyManager) {
        this.userRepo = userRepo;
        this.keyManager = keyManager;
    }

    @Override
    public void createUser(RequestUserDto dto) {
        User user = new User();
        user.setUserId(keyManager.generateKey(new Random().nextInt(15)+5));
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setStatus(true);
        user.setPassword(dto.getPassword());
        user.setAvatarUrl(dto.getAvatarUrl().getBytes());
        userRepo.save(user);

    }

    @Override
    public void updateUser(RequestUserDto dto, String userID) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userID);
        if (selectedUser.isEmpty()) throw new RuntimeException("Id Not Found");
        selectedUser.get().setEmail(dto.getEmail());
        selectedUser.get().setFullName(dto.getFullName());
        selectedUser.get().setAvatarUrl(dto.getAvatarUrl().getBytes());
        selectedUser.get().setPassword(dto.getPassword());
        selectedUser.get().setStatus(dto.getStatus());

        userRepo.save(selectedUser.get());
    }

    @Override
    public ResponseUserDto fidUser(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException("Id Not Found");
    //    String avatar=new String(selectedUser.get().getAvatarUrl(), StandardCharsets.UTF_8);

        ResponseUserDto responseUserDto = new ResponseUserDto(
                selectedUser.get().getUserId(),
                selectedUser.get().getFullName(),
                selectedUser.get().getEmail(),
                new String(selectedUser.get().getAvatarUrl()),
                selectedUser.get().getStatus()
        );


        return responseUserDto;
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> selectedUser = userRepo.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException("Id Not Found");
        userRepo.deleteById(selectedUser.get().getPropertyId());
    }

    @Override
    public PaginateUserResponseUserDto findAllUser(int page, int size, String searchText) {

        List<User> allUser = userRepo.findAllUser(searchText, PageRequest.of(page, size));
        Long count = userRepo.findAllUserCount(searchText);

        List<ResponseUserDto> dtos=new ArrayList<>();
        allUser.forEach(e->{
          dtos.add(new ResponseUserDto(
                  e.getUserId(),
                  e.getFullName(),
                  e.getEmail(),
                  new String(e.getAvatarUrl()),
                  e.getStatus()
          ));
        });

        return new PaginateUserResponseUserDto(count,dtos);
    }
}
