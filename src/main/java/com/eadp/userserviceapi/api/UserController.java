package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping
    public String createUser(@RequestBody RequestUserDto dto){
        return dto.toString();
    }
    @GetMapping
    public String findUser(){
        return " find user";
    }
    @PutMapping
    public String updateUser(){
        return " update user";
    }
    @DeleteMapping
    public String deleteUser(){
        return " delete user";
    }
    @GetMapping("/list")
    public String findAll(){
        return "find all user";
    }
}
