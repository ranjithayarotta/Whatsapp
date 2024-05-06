package com.WhatsApp.WhatsApp.serviceimpl;

import com.WhatsApp.WhatsApp.entity.ChatRoom;
import com.WhatsApp.WhatsApp.repository.ChatRoomRepository;
import com.WhatsApp.WhatsApp.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Override
    public ResponseEntity<Object> getChats(Long userId) {
            try {
                List<ChatRoom> chatRooms = chatRoomRepository.findByUserId(userId);
                return ResponseEntity.ok().body(chatRooms);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        @Override
    public ResponseEntity<Object> saveChatRoom(ChatRoom chatRoom) {
        try {
//            if (chatRoom.getChatRoomId() == null || chatRoom.getUserId() == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ChatRoomId and UserId must be provided.");
//            }
//            MessageTBl messa = chatRoom.getChatRoomId();
            Long user = chatRoom.getUserId();

//            chatRoom.setChatRoomId(messa);
            chatRoom.setUserId(user);

            ChatRoom savedChatRoom = chatRoomRepository.save(chatRoom);
            return ResponseEntity.ok().body(savedChatRoom);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
