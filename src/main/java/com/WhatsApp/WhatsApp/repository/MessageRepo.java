package com.WhatsApp.WhatsApp.repository;


import com.WhatsApp.WhatsApp.entity.MessageTBl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MessageRepo extends JpaRepository<MessageTBl,Long> {


}
