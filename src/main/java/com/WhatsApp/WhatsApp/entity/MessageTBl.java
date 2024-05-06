package com.WhatsApp.WhatsApp.entity;

import com.WhatsApp.WhatsApp.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
@Table(name = "Message")
public class MessageTBl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long msgId;

//    @ManyToOne
//    @JoinColumn(name = "userId", referencedColumnName = "userId")
//    private UserProfile userProfile;

    @Column(name = "UserId")
    private Long userId;

    @Column(name = "Sender")
    private Long senderNbr;

    @Column(name = "Receiver")
    private Long receiverNbr;

    @Column(name = "ChatName")
    private String chatName;

    @Column(name = "Content")
    private String content;

    @Column(name = "ChatRoomId")
    private Long chatRoomId;

    @CreationTimestamp
    @Column(name = "TimeStamp")
    private LocalDateTime createdTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private Status status;

    @Column(name = "AttachMent")
    private String attachment;

    @Column(name = "MessageType")
    private String MessageType;

    @Column(name = "imageFilePath")
    private String imageFilePath;

    @Column(name = "videoFilePath")
    private String videoFilePath;

    @Transient
    private boolean isGroup;

    @Transient
    private boolean isPrivateChat;







//    public MessageTBl(String jsonString) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        MessageTBl temp = objectMapper.readValue(jsonString, MessageTBl.class);
//        this.attachment = temp.attachment;
//        this.chatName = temp.chatName;
//        this.content = temp.content;
//        this.receiverNbr = temp.receiverNbr;
//        this.senderNbr = temp.senderNbr;
//        this.status = temp.status;
//        this.chatRoomId = temp.chatRoomId;
//        this.userProfile = temp.getUserProfile();
//        this.MessageType = temp.MessageType;
//    }

    public MessageTBl() {
    }

}
