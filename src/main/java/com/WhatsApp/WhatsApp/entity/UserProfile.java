package com.WhatsApp.WhatsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name =  "UserProfile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column (name = "Name")
    private String name;

    @Column(name = "About")
    private String about;

    @Column(name = "Phone")
    private Long Phone;

    @Column(name ="Image")
    private String url;

}