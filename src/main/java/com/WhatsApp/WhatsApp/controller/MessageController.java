package com.WhatsApp.WhatsApp.controller;

import com.WhatsApp.WhatsApp.entity.MessageTBl;
import com.WhatsApp.WhatsApp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

//    @PostMapping("/api/messages/save")
//    public ResponseEntity<String> saveMessage(@RequestBody MessageDTO messageDTO) {
//        try {
//            MessageTBl savedMessage = messageService.saveMessage(messageDTO);
//                return new ResponseEntity<>("Saved successFully",HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving message.");
//        }
//    }

    @PostMapping("/api/messages/save")
    public ResponseEntity<String> saveMessage(@RequestParam("message") String message,
                                              @RequestParam("attachment") String attachment,
                                              @RequestBody MessageTBl userDetails) {
        try {
            MessageTBl savedMessage = messageService.saveMessage(message,attachment,userDetails);
            return new ResponseEntity<>("Saved successFully",HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving message.");
        }
    }
    @GetMapping("/message/get")
    public ResponseEntity<Object> getMessage(@RequestParam Long ChatRoomId) {
        try {
                ResponseEntity<Object> message = messageService.getMessage(ChatRoomId);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
