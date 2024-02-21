package com.eadp.userserviceapi.api;

import com.eadp.userserviceapi.dto.commen.BillingAddressDto;
import com.eadp.userserviceapi.dto.requst.RequestUserDto;
import com.eadp.userserviceapi.service.BillingAddressService;
import com.eadp.userserviceapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/billingAddress")
public class BillingAddressController {

    private final BillingAddressService billingAddressService;

    public BillingAddressController(BillingAddressService billingAddressService) {
        this.billingAddressService = billingAddressService;
    }

    @PostMapping(params = "userId")
    public ResponseEntity<StandardResponse> createUser(@RequestBody BillingAddressDto dto,@RequestParam String userId){
        billingAddressService.saveBellingAddress(dto,userId);
        return new ResponseEntity<>(
                new StandardResponse("Billing Address Saved",201,null), HttpStatus.CREATED
        );
    }
    @GetMapping(path = "{userId}")
    public ResponseEntity<StandardResponse>  findUser(@PathVariable String userId){
        return new ResponseEntity<>(
                new StandardResponse("User Data",200,  billingAddressService.findBellingAddress(userId)), HttpStatus.OK
        );
    }
    @PutMapping(params = "userId")
    public  ResponseEntity<StandardResponse>  updateUser(@RequestBody BillingAddressDto dto,@RequestParam String userId) {
        billingAddressService.updateBellingAddress(dto,userId);
        return new ResponseEntity<>(
                new StandardResponse("Billing Address update",201,null), HttpStatus.CREATED
        );
    }
    @DeleteMapping(params = {"userId"})
    public  ResponseEntity<StandardResponse>  deleteUser(@RequestParam String userId){
        billingAddressService.deleteBellingAddress(userId);
        return new ResponseEntity<>(
                new StandardResponse(" Billing Address delete",204,null), HttpStatus.NO_CONTENT
        );
    }

}
