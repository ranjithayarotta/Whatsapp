package com.WhatsApp.WhatsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ChatRoom")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomId;


    @Column(name="userId")
    private Long userId;

    @Column(name = "ChatName")
    private  String chatName;

    @Column(name = "groupChat")
    private Boolean groupChat;

    @Column(name = "privateChat")
    private boolean privateChat;


}
