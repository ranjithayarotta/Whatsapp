package com.WhatsApp.WhatsApp.ServiceTest;

import com.WhatsApp.WhatsApp.controller.ChatRoomController;
import com.WhatsApp.WhatsApp.entity.ChatRoom;
import com.WhatsApp.WhatsApp.service.ChatRoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChatRoomControllerTest {


    @Mock
    private ChatRoomService chatRoomService;

    @InjectMocks
    private ChatRoomController chatRoomController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSaveChatRoom_Success() throws Exception {

        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setChatRoomId(1l);
        chatRoom.setUserId(1L);
        chatRoom.setChatName("Test Chat");
        chatRoom.setGroupChat(true);
        chatRoom.setPrivateChat(false);

        ResponseEntity<Object> mockResponse = ResponseEntity.ok(chatRoom);
        when(chatRoomService.saveChatRoom(any(ChatRoom.class))).thenReturn(mockResponse);
        ResponseEntity<Object> response = chatRoomController.saveChatRoom(chatRoom);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(objectMapper.writeValueAsString(chatRoom), objectMapper.writeValueAsString(response.getBody()));
        verify(chatRoomService, times(1)).saveChatRoom(any(ChatRoom.class));
    }
}
