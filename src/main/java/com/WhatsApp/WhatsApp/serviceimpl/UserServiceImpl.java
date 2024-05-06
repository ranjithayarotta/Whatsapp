package com.WhatsApp.WhatsApp.serviceimpl;

import com.WhatsApp.WhatsApp.entity.UserProfile;
import com.WhatsApp.WhatsApp.repository.UserRepo;
import com.WhatsApp.WhatsApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Override
    public String saveUser(UserProfile userProfile) {
        if (userProfile!=null){
         userRepo.save(userProfile);
        return "user successFully saved";
    }
        return null;
    }

    @Override
    public Optional<UserProfile> getUser(Long id) {
        Optional<UserProfile> userProfile = userRepo.findById(id);
        return userProfile;
    }
}

