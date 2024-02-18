package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.dto.paginate.PaginateUserResponseUserDto;
import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.dto.response.ResponseUserDto;
import com.eadp.userserviceapi.service.UserService;
import com.eadp.userserviceapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<StandardResponse> createUser(@RequestBody RequestUserDto dto){
        userService.createUser(dto);
        return new ResponseEntity<>(
                new StandardResponse("Customer Saved",201,null), HttpStatus.CREATED
        );
    }
    @GetMapping(path = "{userId}")
    public ResponseEntity<StandardResponse>  findUser(@PathVariable String userId){
        return new ResponseEntity<>(
                new StandardResponse("User Data",200,  userService.fidUser(userId)), HttpStatus.OK
        );
    }
    @PutMapping(path = "{userId}")
    public  ResponseEntity<StandardResponse>  updateUser(@RequestBody RequestUserDto dto,@PathVariable String userId) {
        userService.updateUser(dto,userId);
        return new ResponseEntity<>(
                new StandardResponse("Customer Saved",201,null), HttpStatus.CREATED
        );
    }
    @DeleteMapping(params = {"userId"})
    public  ResponseEntity<StandardResponse>  deleteUser(String userId){
    userService.deleteUser(userId);
        return new ResponseEntity<>(
                new StandardResponse("Customer delete",204,null), HttpStatus.NO_CONTENT
        );
    }
    @GetMapping(value = "/list" ,params = {"page","size","searchText"})
    public  ResponseEntity<StandardResponse>  findAll(@RequestParam int page , @RequestParam int size,@RequestParam String searchText){


        return new ResponseEntity<>(
                new StandardResponse("Customer All data",201, userService.findAllUser(page, size, searchText)), HttpStatus.OK
        );
    }
}
