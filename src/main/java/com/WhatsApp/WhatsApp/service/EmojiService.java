package com.WhatsApp.WhatsApp.service;

import com.WhatsApp.WhatsApp.entity.Emojis;

import java.util.List;

public interface EmojiService {

    List<String> getEmojis(String deaFault);

    void saveEmoji(Emojis emojis);


}
