package com.WhatsApp.WhatsApp.repository;

import com.WhatsApp.WhatsApp.entity.ChatRoom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
//    @Query("SELECT cr FROM ChatRoom cr WHERE cr.userId = :userProfile")
//    List<ChatRoom> findByUserProfile(UserProfile userProfile);

    List<ChatRoom> findByUserId(Long userId);

    List<ChatRoom> findByChatRoomId(Long chatRoomId);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO whatsappapplication.chat_room (chat_name, user_Id,group_chat,private_chat) VALUES (:chatName, :userId,:groupChat,:privateChat)", nativeQuery = true)
    void saveChat(String chatName, Long userId,boolean groupChat,boolean privateChat);



}