package com.WhatsApp.WhatsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "emojis")
public class Emojis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "emojiName")
    private String Name;

    @Column(name = "Status")
    private String status;

}
