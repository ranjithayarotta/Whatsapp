package com.WhatsApp.WhatsApp.serviceimpl;

import com.WhatsApp.WhatsApp.entity.ChatRoom;
import com.WhatsApp.WhatsApp.entity.MessageTBl;
import com.WhatsApp.WhatsApp.repository.ChatRoomRepository;
import com.WhatsApp.WhatsApp.repository.MessageRepo;
import com.WhatsApp.WhatsApp.service.MessageService;
import com.WhatsApp.WhatsApp.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Override
    public MessageTBl saveMessage(String message,String attachment,MessageTBl userDetail) throws IOException {
        if (userDetail != null) {
            MessageTBl messageTBl = new MessageTBl();
            messageTBl.setReceiverNbr(userDetail.getReceiverNbr());
            messageTBl.setChatName(userDetail.getChatName());
            messageTBl.setContent(message);
            messageTBl.setSenderNbr(userDetail.getSenderNbr());
            messageTBl.setUserId(userDetail.getUserId());
            messageTBl.setChatRoomId(userDetail.getChatRoomId());
            messageTBl.setMessageType(userDetail.getMessageType());

            byte[] attachmentData = attachment.getBytes();

            String chatName;
            Long userId;
            LocalDateTime currentTime = LocalDateTime.now();
            long fileSizeInKB = attachmentData.length / 1024;

            if (fileSizeInKB <= 10) {
                messageTBl.setAttachment(attachment);
                ObjectMapper objectMapper = new ObjectMapper();
                MessageTBl messageDat = objectMapper.readValue(objectMapper.writeValueAsString(messageTBl), MessageTBl.class);

                messageTBl.setCreatedTime(currentTime);
                messageTBl.setStatus(Status.send);
                MessageTBl savedMessage = messageRepo.save(messageDat);

                if (messageTBl.getChatName() == null) {
                    Long numbr = messageTBl.getReceiverNbr();
                    chatName = String.valueOf(numbr);
                    boolean groupCh = messageTBl.isGroup();
                    boolean privateChat = messageTBl.isPrivateChat();
                    userId = messageTBl.getUserId();
                    chatRoomRepository.saveChat(chatName, userId, groupCh, privateChat);
                } else {
                    chatName = messageTBl.getChatName();
                    userId = messageTBl.getUserId();
                    boolean groupCh = messageTBl.isGroup();
                    boolean privateChat = messageTBl.isPrivateChat();
                    chatRoomRepository.saveChat(chatName, userId, groupCh, privateChat);
                }

                return savedMessage;
            } else {
                throw new IllegalArgumentException("Attachment size exceeds 10KB limit.");
            }
        }
        return userDetail;
    }
    @Override
    public ResponseEntity<Object> getMessage(Long chatRoomId) {
        try {
            List<ChatRoom> chatRoom = chatRoomRepository.findByChatRoomId(chatRoomId);
            if (chatRoom != null) {
                return ResponseEntity.ok(chatRoom.toString());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}



