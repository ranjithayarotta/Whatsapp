package com.WhatsApp.WhatsApp.serviceimpl;

import com.WhatsApp.WhatsApp.entity.Emojis;
import com.WhatsApp.WhatsApp.repository.EmojiRepo;
import com.WhatsApp.WhatsApp.service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmojiServiceImpl implements EmojiService {

    @Autowired
    EmojiRepo emojiRepo;

    @Override
    public List<String> getEmojis(String defaultStatus) {
        List<String> defaultEmoji = new ArrayList<>();
        List<Emojis> emojis = emojiRepo.findByStatus(defaultStatus);
        for (Emojis emoji : emojis) {
            if (emoji.getStatus().equals(defaultStatus)) {
                defaultEmoji.add(emoji.getName());
            }
        }
        return defaultEmoji;
    }
    @Override
    public void saveEmoji(Emojis emojis) {
        try {
            if (emojis != null) {
                emojiRepo.save(emojis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
