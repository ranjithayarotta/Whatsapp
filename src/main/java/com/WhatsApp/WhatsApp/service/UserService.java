package com.WhatsApp.WhatsApp.service;

import com.WhatsApp.WhatsApp.entity.UserProfile;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.Optional;

public interface UserService {

    String saveUser (UserProfile userProfile);

    Optional<UserProfile> getUser(@RequestBody Long id);
}
