package com.WhatsApp.WhatsApp.controller;

import com.WhatsApp.WhatsApp.entity.ChatRoom;
import com.WhatsApp.WhatsApp.repository.UserRepo;
import com.WhatsApp.WhatsApp.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ChatRoom")
public class ChatRoomController {

    @Autowired
    ChatRoomService chatRoomService;

    @Autowired
    UserRepo userRepo;



    @PostMapping("/save")
    public ResponseEntity<Object> saveChatRoom(@RequestBody ChatRoom chatRoom) {
        try {
            ResponseEntity<Object> response = chatRoomService.saveChatRoom(chatRoom);
            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response.getBody());
            } else {
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("get/Chats")
    public ResponseEntity<Object> getChatRoom(@RequestParam Long userId) {
        try {
//            UserProfile userProfile = userRepo.findById(userId).orElseThrow(() -> new OpenApiResourceNotFoundException("User not found"));
            ResponseEntity<Object> message = chatRoomService.getChats(userId);
            return message;
        } catch (Exception e) {e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
