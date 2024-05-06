package com.WhatsApp.WhatsApp.controller;

import com.WhatsApp.WhatsApp.entity.MessageTBl;
import com.WhatsApp.WhatsApp.service.PictureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/photos/videos")
public class PictureSavingController {


    @Autowired
    PictureService pictureService;


    String filepath = "D:\\StudentIfo\\PhotoDirectory";
    String filepathV = "D:\\StudentIfo\\VedioDirectory";


    @RequestMapping(value = ("/savePhoto"), headers = {"Content-Type=multipart/form-data", "Content-Type=application/json"}, method = RequestMethod.POST)
    public ResponseEntity<String> savePhoto(@RequestPart("videoFile") MultipartFile PhotoFile,
                                            @RequestPart String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MessageTBl messageTBl = objectMapper.readValue(message, MessageTBl.class);
            pictureService.savePhoto(PhotoFile, filepath,messageTBl);
            return ResponseEntity.ok("Photo saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving photo.");
        }
    }



//    @GetMapping("/videos")
//    public ResponseEntity<Object> getVideosByChatRoomId(@RequestParam Long chatRoomId) {
//        try {
////            List<MessageTBl> videos = pictureService.getVideosByChatRoomId(chatRoomId);
//            if (!videos.isEmpty()) {
//                return ResponseEntity.ok(videos);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching videos.");
//        }


    @RequestMapping(value = ("/saveVideo"), headers = {"Content-Type=multipart/form-data", "Content-Type=application/json"}, method = RequestMethod.POST)
    public ResponseEntity<String> saveVideo(@RequestPart("videoFile") MultipartFile videoFile,
                                            @RequestPart String message) {
        {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                MessageTBl messageTBl = objectMapper.readValue(message, MessageTBl.class);

                pictureService.saveVideo(videoFile, filepathV, videoFile.getOriginalFilename(),messageTBl);
                return ResponseEntity.ok("Video saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving video.");
            }
        }
    }

//    @PostMapping(value = "/dummy", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<String> save(@RequestParam("videoFile") MultipartFile videoFile, @RequestParam String abc) {
//            {
//            try {
//                pictureService.saveVideo(videoFile, filepathV, videoFile.getOriginalFilename());
//                return ResponseEntity.ok("Video saved successfully.");
//            } catch (IOException e) {
//                e.printStackTrace();
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving video.");
//            }
//        }
//    }
}
