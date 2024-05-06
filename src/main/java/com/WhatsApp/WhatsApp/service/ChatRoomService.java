package com.WhatsApp.WhatsApp.service;

import com.WhatsApp.WhatsApp.entity.ChatRoom;
import org.springframework.http.ResponseEntity;

public interface ChatRoomService {

    ResponseEntity<Object> getChats(Long userId);
    ResponseEntity<Object> saveChatRoom(ChatRoom chatRoom);



}
