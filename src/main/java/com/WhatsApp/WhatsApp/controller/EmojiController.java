package com.WhatsApp.WhatsApp.controller;

import com.WhatsApp.WhatsApp.entity.Emojis;
import com.WhatsApp.WhatsApp.service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emoji")
public class EmojiController {

    @Autowired
    EmojiService emojiService;


    @PostMapping("/saveEmoji")
    public ResponseEntity<String> saveEmoji(@RequestBody Emojis emojis) {
        try {
            emojiService.saveEmoji(emojis);
            return ResponseEntity.ok("Emoji saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save emoji.");
        }
    }


    @GetMapping("/getEmoji")
    public ResponseEntity<List<String>> getEmoji() {
        String defaultStatus = "default";
        List<String> emojis = emojiService.getEmojis(defaultStatus);

        return ResponseEntity.ok(emojis);
    }
}

