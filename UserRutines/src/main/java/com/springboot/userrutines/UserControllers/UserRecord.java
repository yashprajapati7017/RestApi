package com.springboot.userrutines.UserControllers;

import com.springboot.userrutines.Information.Information;
import com.springboot.userrutines.UserEntity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRecord {

    @Autowired
    Information information;

    @GetMapping("/work")
    public List<UserDetails> getUserDetails() {
        return information.getUserDetails();
    }

    @GetMapping("/work/{Id}")
    public UserDetails getUserDetailsById(@PathVariable("Id") int Id) {
        return information.getUserDetailsById(Id);
    }

    @PostMapping("/work")
    public UserDetails postUserDetails(@RequestBody UserDetails userDetails) {
        return information.postUserDetails(userDetails);
    }

    @DeleteMapping("/work/{Id}")
    public void DeleteUserDetails(@PathVariable("Id") int Id) {
        information.setUserDetails(Id);
    }

    @PutMapping("/work/{Id}")
    public void  updateUserDetails(@RequestBody UserDetails userDetails,@PathVariable int Id) {
        information.updateUserDetails(userDetails, Id);
    }

}
