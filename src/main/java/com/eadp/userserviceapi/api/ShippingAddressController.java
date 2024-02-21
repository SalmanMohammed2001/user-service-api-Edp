package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.dto.commen.BillingAddressDto;
import com.eadp.userserviceapi.dto.commen.ShippingAddressDto;
import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.service.ShippingAddressService;
import com.eadp.userserviceapi.service.UserService;
import com.eadp.userserviceapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/shippingAddress")
public class ShippingAddressController {



    private final ShippingAddressService shippingAddressService;

    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }


    @PostMapping(params = "userId")
    public ResponseEntity<StandardResponse> createUser(@RequestBody ShippingAddressDto dto, @RequestParam String userId){
        shippingAddressService.saveShippingAddress(dto,userId);
        return new ResponseEntity<>(
                new StandardResponse("Billing Address Saved",201,null), HttpStatus.CREATED
        );
    }
    @GetMapping(path = "{userId}")
    public ResponseEntity<StandardResponse>  findUser(@PathVariable String userId){
        return new ResponseEntity<>(
                new StandardResponse("User Data",200,  shippingAddressService.findShippingAddress(userId)), HttpStatus.OK
        );
    }
    @PutMapping(params = "userId")
    public  ResponseEntity<StandardResponse>  updateUser(@RequestBody ShippingAddressDto dto,@RequestParam String userId) {
        shippingAddressService.updateShippingAddress(dto,userId);
        return new ResponseEntity<>(
                new StandardResponse("Billing Address update",201,null), HttpStatus.CREATED
        );
    }
    @DeleteMapping(params = {"userId"})
    public  ResponseEntity<StandardResponse>  deleteUser(@RequestParam String userId){
        shippingAddressService.deleteShippingAddress(userId);
        return new ResponseEntity<>(
                new StandardResponse(" Billing Address delete",204,null), HttpStatus.NO_CONTENT
        );
    }

}
