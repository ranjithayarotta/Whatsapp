package com.WhatsApp.WhatsApp.repository;

import com.WhatsApp.WhatsApp.entity.MessageTBl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository  extends JpaRepository<MessageTBl, Long> {

//        List<MessageTBl> findByChatRoomId(Long chatRoomId);
}
