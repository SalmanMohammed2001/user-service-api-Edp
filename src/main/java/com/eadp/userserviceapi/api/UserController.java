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
    @GetMapping(path = "{userId}")
    public String findUser(@PathVariable String userId){
        return userId;
    }
    @PutMapping(path = "{userId}")
    public String updateUser(@RequestBody RequestUserDto dto,@PathVariable String userId) {
        return dto.toString();
    }
    @DeleteMapping(params = {"userId"})
    public String deleteUser(String userId){

        return userId;
    }
    @GetMapping(value = "/list" ,params = {"page","size","searchText"})
    public String findAll(@RequestParam int page , @RequestParam int size,@RequestParam String searchText){
        return "find all user";
    }
}
