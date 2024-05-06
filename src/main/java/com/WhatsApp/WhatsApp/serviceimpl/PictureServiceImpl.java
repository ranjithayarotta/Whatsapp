package com.WhatsApp.WhatsApp.serviceimpl;

import com.WhatsApp.WhatsApp.entity.MessageTBl;
import com.WhatsApp.WhatsApp.entity.UserProfile;
import com.WhatsApp.WhatsApp.repository.MessageRepo;
import com.WhatsApp.WhatsApp.repository.PictureRepository;
import com.WhatsApp.WhatsApp.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String ROOT_DIRECTORY = "root";
    private static final String PHOTO_SUBDIRECTORY = "photos";

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    PictureRepository pictureRepository;
    MessageTBl messageTBl = new MessageTBl();
    UserProfile userProfile = new UserProfile();

    @Override
    public void savePhoto(MultipartFile photoFile, String directory,MessageTBl messageDetails) throws IOException {

        Path photoDirectory = Paths.get(directory);
        if (!Files.exists(photoDirectory)) {
            Files.createDirectories(photoDirectory);
        }
        Path filePath = photoDirectory.resolve(photoFile.getOriginalFilename());
        Files.write(filePath, photoFile.getBytes());
        if (Files.exists(filePath) && Files.size(filePath) > 0) {
            messageTBl.setImageFilePath(filePath.toString());
            messageTBl.setMessageType(messageDetails.getMessageType());
            messageTBl.setContent(messageDetails.getContent());
            messageTBl.setSenderNbr(messageDetails.getSenderNbr());
            messageTBl.setReceiverNbr(messageDetails.getReceiverNbr());
            messageTBl.setChatName(messageDetails.getChatName());
            messageTBl.setChatRoomId(messageDetails.getChatRoomId());
            messageTBl.setAttachment(messageDetails.getAttachment());
            messageTBl.setStatus(messageDetails.getStatus());
            messageTBl.setUserId(messageDetails.getUserId());
            messageRepo.save(messageTBl);
        } else {
            throw new IOException("Failed to write photo file.");
        }
    }
    @Override
    public void saveVideo(MultipartFile videoFile, String directory, String fileName,MessageTBl messageDetails) throws IOException {

        Path videoDirectory = Paths.get(directory);
        if (!Files.exists(videoDirectory)) {
            Files.createDirectories(videoDirectory);
        }
        Path filePath = videoDirectory.resolve(fileName);
        Files.write(filePath, videoFile.getBytes());
        if (Files.exists(filePath) && Files.size(filePath) > 0) {
            messageTBl.setVideoFilePath(filePath.toString());
            messageTBl.setMessageType(messageDetails.getMessageType());
            messageTBl.setContent(messageDetails.getContent());
            messageTBl.setSenderNbr(messageDetails.getSenderNbr());
            messageTBl.setReceiverNbr(messageDetails.getReceiverNbr());
            messageTBl.setChatName(messageDetails.getChatName());
            messageTBl.setChatRoomId(messageDetails.getChatRoomId());
            messageTBl.setAttachment(messageDetails.getAttachment());
            messageTBl.setStatus(messageDetails.getStatus());
            messageTBl.setUserId(messageDetails.getUserId());
              messageRepo.save(messageTBl);
        } else {
            throw new IOException("Failed to write video file.");
        }
    }

//    @Override
////    public List<MessageTBl> getVideosByChatRoomId(Long chatRoomId) {
//////        return pictureRepository.findByChatRoomId(chatRoomId);
////    }
}


