package com.WhatsApp.WhatsApp.controller;

import com.WhatsApp.WhatsApp.entity.UserProfile;
import com.WhatsApp.WhatsApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public String saveUserDetail(@RequestBody UserProfile userProfile) {
        return userService.saveUser(userProfile);
    }

    @GetMapping("/GetProfile")
    public Optional<UserProfile> getUserProfile(@RequestParam Long id){
        return userService.getUser(id);
    }
}
