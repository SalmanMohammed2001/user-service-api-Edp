package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;
import com.eadp.userserviceapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public String createUser(@RequestBody RequestUserDto dto){
        userService.createUser(dto);
        return dto.getFullName();
    }
    @GetMapping(path = "{userId}")

    public ResponseUserDto findUser(@PathVariable String userId){
         return userService.fidUser(userId);

    }
    @PutMapping(path = "{userId}")
    public String updateUser(@RequestBody RequestUserDto dto,@PathVariable String userId) {
        userService.updateUser(dto,userId);
        return dto.getFullName()+" user update ";
    }
    @DeleteMapping(params = {"userId"})
    public String deleteUser(String userId){
    userService.deleteUser(userId);
        return userId + "delete ";
    }
    @GetMapping(value = "/list" ,params = {"page","size","searchText"})
    public String findAll(@RequestParam int page , @RequestParam int size,@RequestParam String searchText){
        return "find all user";
    }
}
