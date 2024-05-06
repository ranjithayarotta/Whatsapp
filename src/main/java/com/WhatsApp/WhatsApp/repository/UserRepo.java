package com.WhatsApp.WhatsApp.repository;

import com.WhatsApp.WhatsApp.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserProfile,Long> {
}
