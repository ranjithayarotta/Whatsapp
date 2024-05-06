package com.WhatsApp.WhatsApp.service;

import com.WhatsApp.WhatsApp.entity.MessageTBl;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface MessageService {

     MessageTBl saveMessage(String message,String attachment,MessageTBl userDetail) throws IOException;

     ResponseEntity<Object> getMessage(Long ChatRoomId);




    }

