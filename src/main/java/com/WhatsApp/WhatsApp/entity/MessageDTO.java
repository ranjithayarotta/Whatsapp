package com.WhatsApp.WhatsApp.entity;

import lombok.Data;

@Data
public class MessageDTO {

    private MessageTBl userData;
    private String message;
    private String attachment;

}
