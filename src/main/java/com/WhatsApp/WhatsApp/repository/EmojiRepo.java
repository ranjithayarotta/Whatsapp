package com.WhatsApp.WhatsApp.repository;

import com.WhatsApp.WhatsApp.entity.Emojis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmojiRepo extends JpaRepository<Emojis,Long> {

    List<Emojis> findByStatus(String status);


}
