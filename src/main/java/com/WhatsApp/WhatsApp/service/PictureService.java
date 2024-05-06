package com.WhatsApp.WhatsApp.service;

import com.WhatsApp.WhatsApp.entity.MessageTBl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PictureService {

    void savePhoto(MultipartFile photoFile, String directory,MessageTBl messageTBl) throws IOException;
    void saveVideo(MultipartFile videoFile, String directory, String fileName,MessageTBl messageTBl) throws IOException;

//    List<MessageTBl> getVideosByChatRoomId(Long chatRoomId);
    }

